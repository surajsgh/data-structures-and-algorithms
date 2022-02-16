class Node1 {
    int data;
    Node1 next;

    Node1(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtTheBeginningOfLinkedList {
    public static void main(String[] args) {
        Node1 head = null;
        head = insertBegin(30, head);
        head = insertBegin(20, head);
        head = insertBegin(10, head);
        print(head);
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static Node1 insertBegin(int x, Node1 head) {
        Node1 temp = new Node1(x);
        temp.next = head;
        return temp;
    }

    public static void print(Node1 head) {
        Node1 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
