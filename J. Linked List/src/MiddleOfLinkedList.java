class Node20 {
    int data;
    Node20 next;

    Node20(int x) {
        data = x;
        next = null;
    }
}

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node20 head = new Node20(10);
        head.next = new Node20(20);
        head.next.next = new Node20(30);
        head.next.next.next = new Node20(40);
        printMiddle(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void printMiddle(Node20 head) {
        if (head==null) {
            return;
        }
        Node20 fast = head;
        Node20 slow = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print(slow.data);
    }
}
