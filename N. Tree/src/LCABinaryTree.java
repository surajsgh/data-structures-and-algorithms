class Node19 {
    int key;
    Node19 left;
    Node19 right;

    Node19(int x) {
        key = x;
        left = right = null;
    }
}

public class LCABinaryTree {
    public static void main(String[] args) {
        Node19 root = new Node19(1);
        root.left = new Node19(2);
        root.right = new Node19(3);
        root.left.left = new Node19(4);
        root.left.right = new Node19(5);
        root.right.left = new Node19(6);
        root.right.right = new Node19(7);
        System.out.println(lca(root, new Node19(4), new Node19(5)));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static Node19 lca(Node19 root, Node19 number1, Node19 number2) {
        if (root==null) return null;
        if (root==number1 || root==number2) {
            return root;
        }
        Node19 lca1 = lca(root.left, number1, number2);
        Node19 lca2 = lca(root.right, number1, number2);
        if (lca1!=null && lca2!=null) {
            return root;
        }
        if (lca1!=null) {
            return lca1;
        }
        else {
            return lca2;
        }
    }
}
