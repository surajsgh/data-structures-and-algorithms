//  Doubly linked list
class Node10 {
    int data;
    Node10 next;
    Node10 prev;

    Node10(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class ReverseTheDoublyLinkedList {
    public static void main(String[] args) {
        Node10 head = new Node10(10);
        Node10 temp1 = new Node10(20);
        Node10 temp2 = new Node10(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        print(head);
        head = reverseLL(head);
        System.out.println();
        print(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node10 reverseLL(Node10 head) {
        if (head==null || head.next==null) {
            return head;
        }
        Node10 prev = null;
        Node10 curr = head;
        while (curr!=null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        return prev.prev;
    }

    public static void print(Node10 head) {
        Node10 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
