class Node29 {
    int data;
    Node29 next;

    Node29(int x) {
        data = x;
        next = null;
    }
}

public class SwapNodesInLinkedList {
    public static void main(String[] args) {
        Node29 head = new Node29(10);
        head.next = new Node29(20);
        head.next.next = new Node29(30);
        head.next.next.next = new Node29(40);
        head.next.next.next.next = new Node29(50);
        printlist(head);
        head = swap(head);
        printlist(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node29 swap(Node29 head) {
        if (head==null || head.next==null) {
            return head;
        }
        Node29 curr = head.next.next;
        Node29 prev = head;
        head = head.next;
        head.next = prev;
        while (curr!=null && curr.next!=null) {
            prev.next = curr.next;
            prev = curr;
            Node29 next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
        return head;
    }


    //  Leetcode version
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    /*
    public ListNode swapPairsAlt(ListNode head) {
        ListNode curr = head;

        while(curr!=null && curr.next!=null) {
            int temp = curr.val;
            curr.val = curr.next.val;
            curr.next.val = temp;
            curr = curr.next.next;
        }

        return head;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;

        while(point.next!=null && point.next.next!=null) {
            ListNode first = point.next;
            ListNode second = point.next.next;
            point.next = second;
            first.next = second.next;
            second.next = first;
            point = first;
        }

        return dummy.next;
    }

     */

    public static void printlist(Node29 head){
        Node29 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
