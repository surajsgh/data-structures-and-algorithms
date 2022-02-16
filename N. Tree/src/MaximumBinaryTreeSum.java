import javax.swing.tree.TreeNode;

class Node27 {
    int val;
    Node27 left;
    Node27 right;

    Node27(int val) {
        val = val;
        left = right = null;
    }
}

public class MaximumBinaryTreeSum {
    int max;
    public int helper(Node27 root) {
        if(root==null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        max = Math.max(max, left + right + root.val);

        return root.val + Math.max(left, right);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public int maxPathSum(Node27 root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
}
