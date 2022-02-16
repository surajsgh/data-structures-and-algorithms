import javax.swing.tree.TreeNode;

class Node13 {
    int val;
    Node13 left;
    Node13 right;

    Node13(int x) {
        val = x;
        left = right = null;
    }
}

public class LCAOfBST {
    //  Time Complexity : O(h)
    //  Auxiliary Space : O(h)
    public Node13 lowestCommonAncestor(Node13 root, Node13 p, Node13 q) {
        if(root==null) return null;
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
