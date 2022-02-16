public class LengthOfTheLoop {
    //  Time Complexity : O(n)
    //` Auxiliary Space : O(1)
    /*
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                Node curr = slow.next;
                int count = 1;

                while(curr!=fast) {
                    curr = curr.next;
                    count++;
                }

                return count;
            }
        }

        return 0;
    }

     */
}
