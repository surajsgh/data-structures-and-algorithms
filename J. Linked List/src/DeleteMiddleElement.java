public class DeleteMiddleElement {
    //  Time Complexity = O(n)
    //  Auxiliary Space = O(1)
     /*
    public ListNode deleteMiddle(ListNode head) {
        ListNode curr = head;
        if(head==null) return null;
        if(head.next==null) return null;

        int length = 0;
        for(ListNode current=head; current!=null; current = current.next) {
            length++;
        }

        for(int i=0; i<length/2-1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }
    */

}
