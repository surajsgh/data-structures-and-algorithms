import javax.swing.tree.TreeNode;

class Node18 {
    int key;
    Node18 left;
    Node18 right;

    Node18(int x) {
        key = x;
        left = right = null;
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node18 root = new Node18(1);
        root.left = new Node18(2);
        root.right = new Node18(3);
        root.left.left = new Node18(4);
        root.left.right = new Node18(5);
        System.out.println(diameterOfBinaryTree(root));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    static int res = 0;
    public static int heightEff(Node18 root) {
        if (root==null) return 0;
        int lh = heightEff(root.left);
        int rh = heightEff(root.right);
        res = Math.max(res, 1+lh+rh);
        return 1+Math.max(lh, rh);
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(h)
    public static int diameterOfBinaryTree(Node18 root) {
        if(root==null) {
            return 0;
        }
        int d1 = 1 + height(root.left) + height(root.right);
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);
        return Math.max(d1+1, Math.max(d2, d3));
    }

    public static int height(Node18 root) {
        if(root==null) {
            return -1;
        }
        else {
            return (Math.max(height(root.left), height(root.right))+1);
        }
    }
}
