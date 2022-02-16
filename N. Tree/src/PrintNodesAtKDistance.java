class Node6 {
    Node6 left;
    Node6 right;
    int key;

    Node6(int x) {
        key = x;
        left = right = null;
    }
}

public class PrintNodesAtKDistance {
    public static void main(String[] args) {
        Node6 root = new Node6(10);
        root.left = new Node6(20);
        root.right = new Node6(30);
        root.right.left = new Node6(25);
        root.right.right = new Node6(35);
        find(root, 1);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void find(Node6 root, int k) {
        if (root==null) return;
        if (k==0) {
            System.out.print(root.key + " ");
        }
        else {
            find(root.left, k-1);
            find(root.right, k-1);
        }

    }
}
