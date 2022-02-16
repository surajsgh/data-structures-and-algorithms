class Node16 {
    int data;
    Node16 next;

    Node16(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtTheEndOfTheCircularLinkedList {
    public static void main(String[] args) {

    }

    //  Time Complexity : O(n)
    public static Node16 insertAt(Node16 head, int x) {
        Node16 temp = new Node16(x);
        if (head==null) {
            temp.next = temp;
            return temp;
        }
        else {
            Node16 curr = head;
            while(curr.next!=head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }
        return temp;
    }
}
