class Deque {
    int size;
    int capacity;
    int[] array;

    public Deque(int cap) {
        capacity = cap;
        size = 0;
        array = new int[capacity];
    }

    public boolean isFull() {
        return size==capacity;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void insertFront(int x) {
        if (isFull()) return;
        for(int i=size-1; i>=0; i--) {
            array[i+1] = array[i];
        }
        array[0] = x;
        size++;
    }

    public int removeFront() {
        if (isEmpty()) return -1;
        int res = array[0];
        for (int i=0; i<size-1; i++) {
            array[i] = array[i+1];
        }
        return res;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return array[0];
    }

    public void insertRear(int x) {
        if (isFull()) return;
        array[size++] = x;
    }

    public int removeRear() {
        if (isEmpty()) return -1;
        int res = array[size-1];
        size--;
        return res;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return array[size-1];
    }
}
