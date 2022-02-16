import java.util.ArrayList;

class Node5 {
    int val;
    Node5 left;
    Node5 right;

    Node5(int x) {
        val = x;
        left = right = null;
    }
}

public class KthSmallestElementInBinarySearchTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int kthSmallest(Node5 root, int k) {
        ArrayList<Integer> list = find(root, new ArrayList<Integer>());
        return list.get(k-1);
    }

    public ArrayList<Integer> find(Node5 root, ArrayList<Integer> list) {
        if(root==null) return list;
        find(root.left, list);
        list.add(root.val);
        find(root.right, list);
        return list;
    }
}
