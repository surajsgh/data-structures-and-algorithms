import javax.swing.tree.TreeNode;

class Node28 {
    int val;
    Node28 left;
    Node28 right;

    Node28(int val) {
        val = val;
        left = right = null;
    }
}

public class MaximumDifferenceBetweenNodeAndItsAncestor {
    public int maxAncestorDiff(Node28 root) {
        return helper(root, root.val, root.val);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public int helper(Node28 root, int maxValue, int minValue) {
        if(root==null) return maxValue-minValue;
        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);
        return Math.max(helper(root.left, maxValue, minValue), helper(root.right, maxValue, minValue));
    }
}
