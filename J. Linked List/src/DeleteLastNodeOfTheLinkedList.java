class Node12 {
    int data;
    Node12 next;
    Node12 prev;

    Node12(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class DeleteLastNodeOfTheLinkedList {
    public static void main(String[] args) {
        Node12 head = new Node12(10);
        Node12 temp1 = new Node12(20);
        Node12 temp2 = new Node12(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        print(head);
        head = deleteLast(head);
        print(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node12 deleteLast(Node12 head) {
        if (head==null) {
            return null;
        }
        if (head.next==null) {
            return null;
        }
        Node12 curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }

    public static void print(Node12 head) {
        Node12 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

