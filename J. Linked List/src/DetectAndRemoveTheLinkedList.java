class Node26 {
    int data;
    Node26 next;

    Node26(int x) {
        data = x;
        next = null;
    }
}

public class DetectAndRemoveTheLinkedList {
    public static void main(String[] args) {
        Node26 head=new Node26(15);
        head.next=new Node26(10);
        head.next.next=new Node26(12);
        head.next.next.next=new Node26(20);
        head.next.next.next.next=head.next;
//        printlist(head);
        detectAndRemove(head);
        printlist(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void detectAndRemove(Node26 head) {
        Node26 fast = head;
        Node26 slow = head;
        while (slow!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                break;
            }
        }
        if (slow!=fast) {
            return;
        }
        slow = head;
        while (slow.next!=fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public static void printlist(Node26 head){
        Node26 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
