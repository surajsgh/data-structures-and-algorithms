class Node3 {
    int data;
    Node3 next;

    Node3(int x) {
        data = x;
        next = null;
    }
}

public class DeleteFirstElementOfALinkedList {
    public static void main(String[] args) {
        Node3 head = new Node3(10);
        head.next = new Node3(20);
        head.next.next = new Node3(30);
        print(head);
        head = del(head);
        print(head);
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static Node3 del(Node3 head) {
        if (head==null) {
            return null;
        }
        else {
            return head.next;
        }
    }

    public static void print(Node3 head) {
        Node3 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
