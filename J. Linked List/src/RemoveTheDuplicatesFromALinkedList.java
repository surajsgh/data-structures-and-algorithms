class Node23 {
    int data;
    Node23 next;

    Node23(int x) {
        data = x;
        next = null;
    }
}

public class RemoveTheDuplicatesFromALinkedList {
    public static void main(String[] args) {
        Node23 head = new Node23(10);
        head.next = new Node23(20);
        head.next.next = new Node23(20);
        head.next.next.next = new Node23(30);
        print(head);
        removeDuplicates(head);
        print(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void removeDuplicates(Node23 head) {
        Node23 curr = head;
        while (curr!=null && curr.next!=null) {
            if (curr.data==curr.next.data) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
    }

    public static void print(Node23 head) {
        Node23 curr = head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
