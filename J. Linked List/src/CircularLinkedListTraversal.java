class Node14 {
    int data;
    Node14 next;

    Node14(int x) {
        data = x;
        next = null;
    }
}

public class CircularLinkedListTraversal {
    public static void main(String[] args) {
        Node14 head = new Node14(10);
        head.next = new Node14(20);
        head.next.next = new Node14(30);
        head.next.next.next = head;
        printLL(head);
    }

    public static void printLL(Node14 head) {
        if (head==null) {
            return;
        }
        System.out.print(head.data + " ");
        for (Node14 n=head.next; n!=head; n=n.next) {
            System.out.print(n.data + " ");
        }
    }
}
