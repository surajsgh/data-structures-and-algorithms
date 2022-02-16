import javax.swing.tree.TreeNode;

class Node34 {
    int data;
    Node34 left;
    Node34 right;

    Node34(int val) {
        data = val;
        left = right = null;
    }
}

public class MinDepthOfBinaryTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public int minDepth(Node34 root) {
        if(root==null) return 0;

        if(root.left==null && root.right==null) return 1;

        if(root.left==null) return minDepth(root.right)+1;

        if(root.right==null) return minDepth(root.left)+1;

        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
