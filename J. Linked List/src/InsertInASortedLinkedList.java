class Node19 {
    int data;
    Node19 next;

    Node19(int x) {
        data = x;
        next = null;
    }
}

public class InsertInASortedLinkedList {
    public static void main(String[] args) {
        Node19 head = new Node19(10);
        head.next = new Node19(20);
        head.next.next = new Node19(30);
        print(head);
        head = sortedInsert(head, 34);
        print(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static Node19 sortedInsert(Node19 head, int x) {
        Node19 temp = new Node19(x);
        if (head==null) {
            return temp;
        }
        if (x<head.data) {
            temp.next = head;
            return temp;
        }
        Node19 curr = head;
        while (curr.next!=null && curr.next.data<x) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static void print(Node19 head) {
        Node19 curr = head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
