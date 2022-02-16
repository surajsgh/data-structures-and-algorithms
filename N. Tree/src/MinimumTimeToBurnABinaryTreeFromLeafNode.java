import java.util.Map;

class Node31 {
    int val;
    Node31 left;
    Node31 right;

    Node31(int val) {
        val = val;
        left = right = null;
    }
}

class Data {
    int val;

    public Data(int distance) {
        val = distance;
    }
}

//  This function does two things
//  1. Returns the maximum height of the respective nodes
//  2. Distance of the node from the given node if it's a descendant

public class MinimumTimeToBurnABinaryTreeFromLeafNode {
    int res = 0;
    public int minimumPoint(Node31 root, Data data, int target) {
        if (root==null) return 0;

        if (root.val==target) {
            data.val = 0;
            return 1;
        }

        Data leftDistance = new Data(-1);
        int leftHeight = minimumPoint(root.left, leftDistance, target);

        Data rightDistance = new Data(-1);
        int rightHeight = minimumPoint(root.right, rightDistance, target);

        if (leftDistance.val!=-1) {
            data.val = leftDistance.val + 1;
            res = Math.max(res, data.val+rightHeight);
        }

        else if (rightDistance.val!=-1) {
            data.val = rightDistance.val + 1;
            res = Math.max(res, data.val+leftHeight);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
