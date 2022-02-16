class Node4 {
    int data;
    Node4 next;

    Node4(int x) {
        data = x;
        next = null;
    }
}

public class DeleteLastOfSinglyLinkedList {
    public static void main(String[] args) {
        Node4 head = new Node4(10);
        head.next = new Node4(20);
        head.next.next = new Node4(30);
        print(head);
        del(head);
        print(head);
    }

    public static void print(Node4 head) {
        Node4 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node4 del(Node4 head) {
        if (head == null) {
            return null;
        }
        if (head.next==null) {
            return null;
        }
        Node4 curr = head;
        while (curr.next.next!=null) {
            curr = curr.next;
        }
        curr.next=null;
        return head;
    }
}
