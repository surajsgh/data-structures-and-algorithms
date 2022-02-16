class Node2 {
    int data;
    Node2 next;

    Node2(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtTheEndOfSinglyLinkedList {
    public static void main(String[] args) {
        Node2 head = null;
        head = insertAtTheEnding(head, 10);
        head = insertAtTheEnding(head, 20);
        head = insertAtTheEnding(head, 30);
        print(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node2 insertAtTheEnding(Node2 head, int x) {
        Node2 temp = new Node2(x);
        if (head == null) {
            return temp;
        }
        Node2 curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static void print(Node2 head) {
        Node2 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
