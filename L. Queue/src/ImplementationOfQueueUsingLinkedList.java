class Node {
    int data;
    Node next;

    public Node(int value) {
        data = value;
        next = null;
    }
}

public class ImplementationOfQueueUsingLinkedList {
    Node front;
    Node rear;
    int size;

    public ImplementationOfQueueUsingLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int x) {
        Node node = new Node(x);
        if (front==null) {
            front = node;
            rear = node;
        }
        else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public void dequeue() {
        if (front==null) return;
        front = front.next;
        if (front==null) rear = null;
        size--;
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        if (front==null) return -1;
        return front.data;
    }

    public int getRear() {
        if (rear==null) return -1;
        return rear.data;
    }
}
