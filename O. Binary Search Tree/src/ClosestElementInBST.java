class Node14 {
    int val;
    Node14 left;
    Node14 right;

    Node14(int x) {
        val = x;
        left = right = null;
    }
}

public class ClosestElementInBST {
    //  Time Complexity : O(h)
    //  Auxiliary Space : O(1)
    static int minDiff(Node14 root, int K)
    {
        // Write your code here
        if(root==null) return 0;

        int minDiff = Integer.MAX_VALUE;
        Node14 closestElement = null;

        while(root!=null) {
            int currDiff = Math.abs(root.val-K);

            if(minDiff>currDiff) {
                minDiff = currDiff;
                closestElement = root;
            }

            if(root.val<K) {
                root = root.right;
            }
            else if(root.val>K) {
                root = root.left;
            }
            else {
                break;
            }
        }
        return minDiff;
    }
}
