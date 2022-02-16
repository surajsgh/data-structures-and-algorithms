class Node15 {
    int val;
    Node15 left;
    Node15 right;

    Node15(int x) {
        val = x;
        left = right = null;
    }
}

public class CountBSTNodesThatLieInThatRange {
    //  Time Complexity : O(h+k)
    //  Auxiliary Space : O(h)
    int getCount(Node15 root,int l, int h)
    {
        //Your code here
        if(root==null) return 0;
        if(root.val>=l && root.val<=h) {
            return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
        }
        else if(root.val<l) {
            return getCount(root.right, l, h);
        }
        else {
            return getCount(root.left, l, h);
        }
    }
}
