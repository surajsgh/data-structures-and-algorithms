import javax.swing.tree.TreeNode;

class Node16 {
    int val;
    Node16 left;
    Node16 right;

    Node16(int x) {
        val = x;
        left = right = null;
    }
}

public class BSTFromPreorder {
    int i = 0;
    public Node16 bstFromPreorder(int[] preorder) {
        return bstUsingRange(preorder, Integer.MAX_VALUE);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public Node16 bstUsingRange(int[] preorder, int bound) {
        if(i==preorder.length || preorder[i]>bound) return null;
        Node16 root = new Node16(preorder[i++]);
        root.left = bstUsingRange(preorder, root.val);
        root.right = bstUsingRange(preorder, bound);
        return root;
    }
}
