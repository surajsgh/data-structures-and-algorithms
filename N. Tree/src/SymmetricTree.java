class Node22 {
    int key;
    Node22 left;
    Node22 right;

    Node22(int val) {
        key = val;
        left = right = null;
    }
}

public class SymmetricTree {
    public boolean isSymmetric(Node22 root) {
        return helper(root, root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public boolean helper(Node22 root1, Node22 root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return (root1.key==root2.key && helper(root1.right, root2.left) && helper(root1.left, root2.right));
    }
}
