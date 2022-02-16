class Node27 {
    int data;
    Node27 next;

    Node27(int x) {
        data = x;
        next = null;
    }
}

public class DeleteNodeWithoutHeadPointer {
    public static void main(String[] args) {
        Node27 head=new Node27(10);
        head.next=new Node27(20);
        Node27 ptr=new Node27(30);
        head.next.next=ptr;
        head.next.next.next=new Node27(40);
        head.next.next.next.next=new Node27(25);
        printlist(head);
        deleteNode(ptr);
        printlist(head);
    }

    //  Time Complexity : O(1)
    //  Auxiliary space : O(1)
    public static void deleteNode(Node27 ptr){
        Node27 temp=ptr.next;
        ptr.data=temp.data;
        ptr.next=temp.next;
    }

    //  Leetcode version
    /*
    public void deleteNodeAlt(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

     */

    public static void printlist(Node27 head){
        Node27 curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
