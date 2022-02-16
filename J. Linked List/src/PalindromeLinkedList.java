public class PalindromeLinkedList {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    /*
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast!=null) {
            slow = slow.next;
        }

        ListNode newHead = reverseList(slow);
        ListNode curr = head;

        while(newHead!=null) {
            if(curr.val!=newHead.val) {
                return false;
            }
            newHead = newHead.next;
            curr = curr.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    *
     */
}
