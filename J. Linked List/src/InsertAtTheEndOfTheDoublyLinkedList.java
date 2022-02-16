//  Doubly Linked List
class Node9 {
    int data;
    Node9 next;
    Node9 prev;

    Node9 (int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class InsertAtTheEndOfTheDoublyLinkedList {
    public static void main(String[] args) {
        Node9 head = new Node9(10);
        Node9 temp1 = new Node9(20);
        Node9 temp2 = new Node9(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        head = insertAtEnd(head, 22);
        print(head);
    }

    public static Node9 insertAtEnd(Node9 head, int x) {
        Node9 temp = new Node9(x);
        if (head==null) {
            return temp;
        }
        Node9 curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static void print(Node9 head) {
        Node9 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
