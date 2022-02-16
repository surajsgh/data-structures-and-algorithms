import java.util.HashSet;

class Node8 {
    int val;
    Node8 left;
    Node8 right;

    Node8(int x) {
        val = x;
        left = right = null;
    }
}

public class TwoSumInBST {
    public boolean findTarget(Node8 root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public boolean helper(Node8 root, int k, HashSet<Integer> set) {
        if(root==null) {
            return false;
        }
        if(helper(root.left, k, set)) {
            return true;
        }
        if(set.contains(k-root.val)) {
            return true;
        }
        else {
            set.add(root.val);
        }
        return helper(root.right, k, set);
    }
}
