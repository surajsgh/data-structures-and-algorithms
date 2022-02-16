public class RotateList {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    /*
    public Node rotate(Node head, int k) {
        // add code here
        if(k==0) return head;

        Node curr = head;
        int count = 1;

        while(count<k && curr!=null) {
            curr = curr.next;
            count++;
        }

        if(curr==null) return head;

        Node kthNode = curr;

        while(curr.next!=null) {
            curr = curr.next;
        }

        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

     */
}
