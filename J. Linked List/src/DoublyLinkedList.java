//  Implementation of doubly linked list.
class Node7 {
    int data;
    Node7 next;
    Node7 prev;

    Node7(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        Node7 head = new Node7(10);
        Node7 temp1 = new Node7(20);
        Node7 temp2 = new Node7(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
    }
}
