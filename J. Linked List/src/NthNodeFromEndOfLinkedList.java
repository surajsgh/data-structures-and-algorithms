class Node21 {
    int data;
    Node21 next;

    Node21(int x) {
        data = x;
        next = null;
    }
}

public class NthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        Node21 head = new Node21(10);
        head.next = new Node21(12);
        head.next.next = new Node21(14);
        head.next.next.next = new Node21(11);
        head.next.next.next.next = new Node21(22);
        printNthFromEnd(head, 6);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void printNthFromEnd(Node21 head, int n) {
        if (head==null) {
            return;
        }
        Node21 first = head;
        for (int i=0; i<n; i++) {
            if (first==null) {
                return;
            }
            first = first.next;
        }
        Node21 second = head;
        while (first!=null) {
            first = first.next;
            second = second.next;
        }
        System.out.print(second.data);
    }

    //  Leetcode version
    public Node21 removeNthFromEnd(Node21 head, int n) {
        Node21 fast = head;
        Node21 slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
