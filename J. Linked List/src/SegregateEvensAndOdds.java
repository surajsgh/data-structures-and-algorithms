class Node28 {
    int data;
    Node28 next;

    Node28(int x) {
        data = x;
        next = null;
    }
}

public class SegregateEvensAndOdds {
    public static void main(String[] args) {
        Node28 head=new Node28(17);
        head.next=new Node28(15);
        head.next.next=new Node28(8);
        head.next.next.next=new Node28(12);
        head.next.next.next.next=new Node28(10);
        head.next.next.next.next.next=new Node28(5);
        head.next.next.next.next.next.next=new Node28(4);
        printlist(head);
        head = seg(head);
        printlist(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node28 seg(Node28 head) {
        Node28 startEven = null;
        Node28 startOdd = null;
        Node28 endEven = null;
        Node28 endOdd = null;
        for (Node28 curr = head; curr!=null; curr = curr.next) {
            int x = curr.data;
            if (x%2==0) {
                if (startEven==null) {
                    startEven = curr;
                    endEven = startEven;
                }
                else {
                    endEven.next = curr;
                    endEven = endEven.next;
                }
            }
            else {
                if (startOdd==null) {
                    startOdd = curr;
                    endOdd = startOdd;
                }
                else {
                    endOdd.next = curr;
                    endOdd = endOdd.next;
                }
            }
        }
        if (startEven==null || startOdd==null) {
            return head;
        }
        endEven.next = startOdd;
        endOdd.next = null;
        return startEven;
    }

    public static void printlist(Node28 head){
        Node28 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
