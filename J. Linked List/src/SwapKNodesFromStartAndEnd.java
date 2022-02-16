public class SwapKNodesFromStartAndEnd {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    /*
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head;
        ListNode second = head;

        for(int i=0; i<k-1; i++) {
            fast = fast.next;
        }

        first = fast;

        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(fast==null) return head;

        second = slow;

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
     */
}
