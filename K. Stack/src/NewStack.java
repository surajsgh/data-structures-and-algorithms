//  Implementation of Stack using linked list.
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class NewStack {
    Node head;
    int sz;

    NewStack() {
        head = null;
        sz = 0;
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        sz++;
    }

    int pop() {
        if (head==null) {
            return Integer.MAX_VALUE;
        }
        int res = head.data;
        Node temp = head;
        head = temp.next;
        sz--;
        return res;
    }

    int peek() {
        if (head==null) {
            return Integer.MAX_VALUE;
        }
        return head.data;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return head==null;
    }
}
