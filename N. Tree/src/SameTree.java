class Node21 {
    int key;
    Node21 left;
    Node21 right;

    Node21(int val) {
        key = val;
        left = right = null;
    }
}

public class SameTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static boolean isSame(Node21 firstRoot, Node21 secondRoot) {
        if (firstRoot==null && secondRoot==null) return true;
        if (firstRoot!=null && secondRoot!=null) {
            return (firstRoot.key==secondRoot.key && isSame(firstRoot.left, secondRoot.left) && isSame(firstRoot.right, secondRoot.right));
        }
        return false;
    }
}
