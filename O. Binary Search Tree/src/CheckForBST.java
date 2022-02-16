import javax.swing.tree.TreeNode;

class Node6 {
    int val;
    Node6 left;
    Node6 right;

    Node6(int x) {
        val = x;
        left = right = null;
    }
}

public class CheckForBST {
    Node6 prev = null;
    //  In-Order Traversal
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public boolean isValidBST(Node6 root) {
        if(root==null) {
            return true;
        }
        if(isValidBST(root.left) && (prev==null || root.val > prev.val)) {
            prev = root;
            return isValidBST(root.right);
        }
        return false;
    }

    //  Pre-Order Traversal
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public boolean isValidBSTRange(Node6 root, int min, int max) {
        if (root==null) return true;
        return (root.val>min && root.val<max && isValidBSTRange(root.left, min, root.val) && isValidBSTRange(root.right, root.val, max));
    }
}
