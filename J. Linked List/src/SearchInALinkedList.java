class Node6 {
    int data;
    Node6 next;

    Node6(int x) {
        data = x;
        next = null;
    }
}

public class SearchInALinkedList {
    public static void main(String[] args) {
        Node6 node = new Node6(10);
        node.next = new Node6(20);
        node.next.next = new Node6(30);
        node.next.next.next = new Node6(40);
        print(node);
        System.out.println();
        System.out.print(search(node, 20));
    }

    public static void print(Node6 head) {
        Node6 temp = head;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //  Time Complexity : O(n)
    public static int search(Node6 head, int x) {
        int position = 1;
        Node6 curr = head;
        while (curr!=null) {
            if (curr.data==x) {
                return position;
            }
            else {
                curr = curr.next;
                position++;
            }
        }
        return -1;
    }
}
