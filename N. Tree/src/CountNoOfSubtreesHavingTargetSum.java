import javax.swing.tree.TreeNode;

class Node29 {
    int val;
    Node29 left;
    Node29 right;

    Node29(int val) {
        val = val;
        left = right = null;
    }
}

public class CountNoOfSubtreesHavingTargetSum {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    int count=0;
    public int pathSum(Node29 root, int targetSum) {
        if(root==null) return 0;
        helper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    public void helper(Node29 root, int targetSum, int currentSum) {
        if(root==null) return;
        currentSum += root.val;
        if(targetSum==currentSum) count++;
        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
    }
}
