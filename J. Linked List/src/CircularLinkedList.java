class Node13 {
    int data;
    Node13 next;
    Node13(int d){
        data=d;
        next=null;
    }
}

public class CircularLinkedList {
    public static void main(String args[]) {
        Node13 head=new Node13(10);
        head.next=new Node13(5);
        head.next.next=new Node13(20);
        head.next.next.next=new Node13(15);
        head.next.next.next.next=head;

    }
}
