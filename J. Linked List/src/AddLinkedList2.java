import java.util.Stack;

public class AddLinkedList2 {
    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(m+n)
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> first = new Stack<Integer>();
        Stack<Integer> second = new Stack<Integer>();

        while(l1!=null) {
            first.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null) {
            second.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode dummy = new ListNode(0);

        while(!first.isEmpty() || !second.isEmpty()) {
            if(!first.isEmpty()) sum += first.pop();
            if(!second.isEmpty()) sum += second.pop();
            dummy.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = dummy;
            dummy = head;
            sum/=10;
        }

        return dummy.val==0 ? dummy.next : dummy;
    }
    /
     */
}
