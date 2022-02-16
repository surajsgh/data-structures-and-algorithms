class Node32 {
    int data;
    Node32 left;
    Node32 right;

    Node32(int val) {
        data = val;
        left = right = null;
    }
}

public class SumTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    boolean isSumTree(Node32 root)
    {
        int ls=0;
        int rs=0;

        if(root==null || isLeaf(root)==1) return true;

        if(isSumTree(root.left)!=false && isSumTree(root.right)!=false) {
            if(root.left==null) {
                ls = 0;
            }
            else if(isLeaf(root.left)!=0) {
                ls = root.left.data;
            }
            else {
                ls = 2 * (root.left.data);
            }

            if(root.right==null) {
                rs = 0;
            }
            else if(isLeaf(root.right)!=0) {
                rs = root.right.data;
            }
            else {
                rs = 2 * (root.right.data);
            }

            if(ls+rs==root.data) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    int isLeaf(Node32 root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return 0;
    }
}
