class Node25 {
    int data;
    Node25 next;

    Node25(int x) {
        data = x;
        next = null;
    }
}

public class DetectLoopInALinkedList {
    public static void main(String[] args) {
        Node25 head=new Node25(15);
        head.next=new Node25(10);
        head.next.next=new Node25(12);
        head.next.next.next=new Node25(20);
        head.next.next.next.next=head.next;
        if (isLoop(head)) {
            System.out.print("Loop");;
        }
        else {
            System.out.print("Not loop");
        }
    }

    //  Time complexity : O(n)
    //  Auxiliary Space : O(1)
    public static boolean isLoop(Node25 head) {
        Node25 curr = head;
        Node25 temp = new Node25(0);
        while (curr!=null) {
            if (curr.next==null) {
                return false;
            }
            if (curr.next==temp) {
                return true;
            }
            Node25 currNext = curr.next;
            curr.next=temp;
            curr=currNext;
        }
        return false;
    }

    //  Floyd-Cycle detection method
    public static boolean isLoopMod(Node25 head) {
        Node25 slow = head;
        Node25 fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }

    public static void printlist(Node25 head){
        Node25 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
