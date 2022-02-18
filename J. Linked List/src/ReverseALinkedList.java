class Node22 {
    int data;
    Node22 next;

    Node22(int x) {
        data = x;
        next = null;
    }
}

public class ReverseALinkedList {
    public static void main(String[] args) {
        Node22 head = new Node22(10);
        head.next = new Node22(20);
        head.next.next = new Node22(30);
        print(head);
        head = reverseLLRec(head);
        System.out.println();
        print(head);
    }

    //  Iteratively
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node22 reverseLL(Node22 head) {
        Node22 prev = null;
        Node22 curr = head;
        while (curr!=null) {
            Node22 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //  Recursively
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static Node22 reverseLLRec(Node22 head) {
        if (head==null || head.next==null) {
            return head;
        }
        Node22 recHead = reverseLLRec(head.next);
        Node22 recTail = head.next;
        recTail.next = head;
        head.next = null;
        return recHead;
    }

    public static Node22 reverseLLRecEff(Node22 head, Node22 prev) {
        if (head==null) return prev;
        Node22 next = head.next;
        head.next = prev;
        return reverseLLRecEff(next, head);
    }

    public static void print(Node22 head) {
        Node22 curr = head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
