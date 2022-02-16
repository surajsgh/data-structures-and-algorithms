class Node15 {
    int data;
    Node15 next;

    Node15(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtTheBeginningOfCircularLinkedList {
    //  Time Complexity : O(n)
    public static Node15 insertAt(Node15 head, int x) {
        Node15 temp = new Node15(x);
        if (head==null) {
            temp.next = temp;
            return temp;
        }
        else {
            Node15 curr = head;
            while(curr.next!=head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
        }
        return temp;
    }
}
