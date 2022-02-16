//  All these operations happen in O(1) time.
class Queue {
    int capacity;
    int size;
    int[] array;

    public Queue(int cap) {
        capacity = cap;
        size = 0;
        array = new int[capacity];
    }

    boolean isFull() {
        return (size==capacity);
    }

    boolean isEmpty() {
        return (size==0);
    }

    int getFront() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return array[0];
        }
    }

    int getRear() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return array[size-1];
        }
    }

    void enqueue(int item) {
        if (isFull()) {
            return;
        }
        array[size++] = item;
    }

    void deque() {
        if (isEmpty()) {
            return;
        }
        for (int i=0; i<size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
    }
}

public class ImplementationOfQueueUsingArray {
    public static void main(String[] args) {
        Queue queue = new Queue(1000);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
        queue.deque();
        System.out.println(queue.getFront());
        System.out.println(queue.getRear());
    }
}
