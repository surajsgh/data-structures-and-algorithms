class Node5 {
    Node5 left;
    Node5 right;
    int key;

    Node5(int x) {
        key = x;
        left = right = null;
    }
}
public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node5 root = new Node5(10);
        root.left = new Node5(20);
        root.right = new Node5(30);
        root.right.left = new Node5(25);
        root.right.right = new Node5(35);
        System.out.println(maxDepth(root));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static int maxDepth(Node5 root) {
        if (root==null) {
            return 0;
        }
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }
}
