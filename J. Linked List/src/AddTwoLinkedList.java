public class AddTwoLinkedList {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1!=null || l2!=null || carry!=0) {
            if(l1!=null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry%10);
            carry = carry/10;
            curr = curr.next;
        }

        return dummy.next;
    }

     */
}
