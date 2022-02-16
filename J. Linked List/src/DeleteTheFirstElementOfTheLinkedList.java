//  Doubly linked list
class Node11 {
    int data;
    Node11 next;
    Node11 prev;

    Node11(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class DeleteTheFirstElementOfTheLinkedList {
    public static void main(String[] args) {
        Node11 head = new Node11(10);
        Node11 temp1 = new Node11(20);
        Node11 temp2 = new Node11(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        print(head);
        head = deleteFirst(head);
        print(head);
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static Node11 deleteFirst(Node11 head) {
        if (head==null) {
            return null;
        }
        if (head.next==null) {
            return null;
        }
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    public static void print(Node11 head) {
        Node11 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
