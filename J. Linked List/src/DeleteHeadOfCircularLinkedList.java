class Node17 {
    int data;
    Node17 next;

    Node17(int x) {
        data = x;
        next = null;
    }
}

public class DeleteHeadOfCircularLinkedList {
    public static Node17 deleteLL(Node17 head) {
        if (head==null) {
            return null;
        }
        if (head.next==null) {
            return null;
        }
        Node17 curr = head;
        while(curr.next!=head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return curr.next;
    }

    public static Node17 deleteLLEff(Node17 head) {
        if (head==null) {
            return null;
        }
        if (head.next==null) {
            return null;
        }
        Node17 curr = head;
        curr.data = curr.next.data;
        curr.next = curr.next.next;
        return curr;
    }
}
