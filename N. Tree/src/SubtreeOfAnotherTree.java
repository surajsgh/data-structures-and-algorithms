class Node23 {
    int key;
    Node23 left;
    Node23 right;

    Node23(int val) {
        key = val;
        left = right = null;
    }
}

public class SubtreeOfAnotherTree {
    public boolean isSubtree(Node23 root, Node23 subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;
        if(isSame(root, subRoot)) return true;
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(h)
    public boolean isSame(Node23 root, Node23 subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        return (root.key==subRoot.key && isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right));
    }
}
