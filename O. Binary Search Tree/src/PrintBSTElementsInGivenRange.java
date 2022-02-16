import java.util.ArrayList;

class Node19 {
    int data;
    Node19 left;
    Node19 right;

    Node19(int x) {
        data = x;
        left = right = null;
    }
}

public class PrintBSTElementsInGivenRange {
    public static ArrayList<Integer> printNearNodes(Node19 root, int low, int high) {
        // code here.
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, low, high, list);
        return list;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void helper(Node19 root, int low, int high, ArrayList<Integer> list) {
        if(root==null) {
            return;
        }
        if(root.data>low) {
            helper(root.left, low, high, list);
        }
        if(root.data>=low && root.data<=high) {
            list.add(root.data);
        }
        if(root.data<high) {
            helper(root.right, low, high, list);
        }
    }
}
