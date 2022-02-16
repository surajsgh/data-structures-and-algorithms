class Node26 {
    int key;
    Node26 left;
    Node26 right;

    Node26(int val) {
        key = val;
        left = right = null;
    }
}

public class FoldableTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    boolean IsFoldable(Node26 node)
    {
        if(node==null) return true;
        return helper(node.left, node.right);
    }

    boolean helper(Node26 firstNode, Node26 secondNode) {
        if(firstNode==null && secondNode==null) return true;
        if(firstNode==null || secondNode==null) return false;
        return (helper(firstNode.left, secondNode.right) && helper(firstNode.right, secondNode.left));
    }
}
