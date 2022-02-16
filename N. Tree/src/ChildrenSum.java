class Node12 {
    int key;
    Node12 left;
    Node12 right;

    Node12 (int x) {
        key = x;
        left = right = null;
    }
}

public class ChildrenSum {
    public static void main(String[] args) {
        Node12 root = new Node12(10);
        root.left = new Node12(20);
        root.right = new Node12(30);
        root.right.left = new Node12(25);
        root.right.right = new Node12(35);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static boolean check(Node12 root) {
        if (root==null) {
            return true;
        }
        if (root.left==null && root.right==null) {
            return true;
        }
        int sum = 0;
        if (root.left!=null) {
            sum += root.left.key;
        }
        if (root.right!=null) {
            sum += root.right.key;
        }
        return (sum==root.key && check(root.left) && check(root.right));
    }
}
