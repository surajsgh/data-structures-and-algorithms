//  Doubly linked list
class Node8 {
    int data;
    Node8 next;
    Node8 prev;

    Node8(int x) {
        data = x;
        next = null;
        prev = null;
    }
}

public class InsertAtTheBeginningOfTheLinkedList {
    public static void main(String[] args) {
        Node8 head=new Node8(10);
        Node8 temp1=new Node8(20);
        Node8 temp2=new Node8(30);
        head.next=temp1;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        head = insertAt(head, 11);
        print(head);
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static Node8 insertAt(Node8 head, int data) {
        Node8 temp = new Node8(data);
        temp.next = head;
        if (head!=null) {
            head.prev = temp;
        }
        return temp;
    }

    public static void print(Node8 head) {
        Node8 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
