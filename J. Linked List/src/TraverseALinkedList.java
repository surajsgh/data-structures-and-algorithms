class NewNode {
    int data;
    NewNode next;

    NewNode(int x) {
        data = x;
        next = null;
    }
}

public class TraverseALinkedList {
    public static void main(String[] args) {
        NewNode head = new NewNode(10);
        head.next = new NewNode(20);
        head.next.next = new NewNode(30);
        head.next.next.next = new NewNode(40);
        printIterative(head);
        printRecursive(head);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void printIterative(NewNode head) {
        NewNode curr = head;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    //  Auxiliary Space : O(n)
    //  Time Complexity : O(n)
    public static void printRecursive(NewNode head) {
        if (head==null) {
            return;
        }
        System.out.print(head.data + " ");
        printIterative(head.next);
    }
}
