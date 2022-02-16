class Node24 {
    int data;
    Node24 next;

    Node24(int x) {
        data = x;
        next = null;
    }
}

public class ReverseALinkedListInGroupOfSizeK {
    public static void main(String[] args) {
        Node24 head=new Node24(10);
        head.next=new Node24(20);
        head.next.next=new Node24(30);
        head.next.next.next=new Node24(40);
        head.next.next.next.next=new Node24(50);
        head.next.next.next.next.next=new Node24(60);
        head.next.next.next.next.next.next=new Node24(70);
        printlist(head);
        head = reversek(head, 3);
        printlist(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node24 reversek(Node24 head, int k) {
        Node24 curr = head;
        Node24 prevFirst = null;
        boolean isFirstPass = true;
        while (curr!=null) {
            Node24 first = curr;
            Node24 prev = null;
            int count = 0;
            while (curr!=null && count < k) {
                Node24 next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            }
            else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }

    public static void printlist(Node24 head){
        Node24 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
