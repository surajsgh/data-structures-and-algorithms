import java.util.HashSet;
import java.util.Set;

public class SortAnUnsortedLinkedList {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    /*
    public Node removeDuplicates(Node head)
    {
        // Your code here
        Node curr = head;
        Node prev = null;

        Set<Integer> set = new HashSet<Integer>();

        while(curr!=null) {
            if(set.contains(curr.data)) {
                prev.next = curr.next;
            }
            else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }
    *
     */
}
