import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Node9 {
    int val;
    Node9 left;
    Node9 right;

    Node9(int x) {
        val = x;
        left = right = null;
    }
}

public class VerticalSumInBinaryTree {
    public static void main(String[] args) {
        Node9 root = new Node9(10);
        root.left = new Node9(20);
        root.right = new Node9(50);
        root.left.left = new Node9(30);
        root.left.right = new Node9(40);
        findVerticalSum(root);
    }

    //  Time Complexity : O(nlog(hd))
    //  Auxiliary Space : O(h+hd)
    public static void findVerticalSum(Node9 root) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        helper(root, 0, map);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void helper(Node9 root, int horizontalDistance, TreeMap<Integer, Integer> map) {
        if(root==null) return;
        helper(root.left, horizontalDistance-1, map);
        int value = map.get(horizontalDistance)==null ? 0:map.get(horizontalDistance);
        map.put(horizontalDistance, root.val+value);
        helper(root.right, horizontalDistance+1, map);
    }
}
