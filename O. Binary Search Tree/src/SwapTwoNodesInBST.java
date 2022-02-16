
class Node7 {
    int val;
    Node7 left;
    Node7 right;

    Node7(int x) {
        val = x;
        left = right = null;
    }
}

public class SwapTwoNodesInBST {
    Node7 prev = null;
    Node7 first = null;
    Node7 second = null;

    public void recoverTree(Node7 root) {
        solution(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public void solution(Node7 root) {
        if(root==null) {
            return;
        }
        solution(root.left);
        if(prev!=null && (prev.val > root.val)) {
            if(first==null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        solution(root.right);
    }
}
