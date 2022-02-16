class Node10 {
    int key;
    Node10 left;
    Node10 right;

    Node10 (int x) {
        key = x;
        left=right=null;
    }
}

public class MaximumInBinaryTree {
    public static void main(String[] args) {
        Node10 root = new Node10(10);
        root.left = new Node10(20);
        root.right = new Node10(30);
        root.right.left = new Node10(25);
        root.right.right = new Node10(35);
        System.out.println(getMax(root));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static int getMax(Node10 root) {
        if (root==null) {
            return 0;
        }
        else {
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
        }
    }
}
