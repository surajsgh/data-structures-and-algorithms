import java.util.LinkedList;

class Node31 {
    int data;
    Node31 next;

    Node31(int x) {
        data = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        Node31 head1 = new Node31(3);
        head1.next = new Node31(6);
        head1.next.next = new Node31(9);
        head1.next.next.next = new Node31(15);
        head1.next.next.next.next = new Node31(30);

        Node31 head2 = new Node31(10);
        head2.next = new Node31(15);
        head2.next.next = new Node31(30);
        System.out.println(getNode(head1, head2));
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(1)
    public static int getNode(Node31 head1, Node31 head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d = Math.abs(c1-c2);

        Node31 current1 = head1;
        Node31 current2 = head2;

        for (int i=0; i<d; i++) {
            if (current1==null) {
                return -1;
            }
            current1 = current1.next;
        }

        while (current1!=null && current2!=null) {
            if (current1.data==current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }

    public static int getCount(Node31 head) {
        Node31 curr = head;
        int count = 0;
        while (curr!=null) {
            curr = curr.next;
            count++;
        }
        return count;
    }
}
