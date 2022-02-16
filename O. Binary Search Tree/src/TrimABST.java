import javax.swing.tree.TreeNode;

class Node20 {
    int val;
    Node20 left;
    Node20 right;

    Node20(int x) {
        val = x;
        left = right = null;
    }
}

public class TrimABST {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public Node20 trimBST(Node20 root, int low, int high) {
        if(root==null) return null;

        if(root.val<low) return trimBST(root.right, low, high);
        if(root.val>high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
