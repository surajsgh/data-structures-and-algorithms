public class MergeSortLinkedList {
    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(n)
    /*
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null) return head;

        Node prev = head;
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(slow);

        return merge(left, right);
    }

    static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while(first!=null && second!=null) {
            if(first.data<second.data) {
                curr.next = first;
                first = first.next;
            }
            else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }

        if(first!=null) {
            curr.next = first;
        }

        if(second!=null) {
            curr.next = second;
        }

        return dummy.next;
    }
    */
}
