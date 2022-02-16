class Node5 {
    int data;
    Node5 next;

    Node5(int x) {
        data = x;
        next = null;
    }
}

public class InsertAtAGivenPositionInALinkedList {
    public static void main(String[] args) {
        Node5 node = new Node5(10);
//        node.next = new Node5(10);
        node.next = new Node5(20);
        node.next.next = new Node5(30);
        print(node);
        insertPos(node, 9, 15);
        print(node);
    }

    //  Time Complexity : O(n)
    public static Node5 insertPos(Node5 head, int pos, int data) {
        Node5 temp = new Node5(data);
        if (pos==1) {
            temp.next = head;
            return temp;
        }
        Node5 curr = head;
        for (int i=1; i<=pos-2 && curr!=null; i++) {
            curr = curr.next;
        }
        if (curr==null) {
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;
    }

    public static void print(Node5 head) {
        Node5 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
