import javax.swing.tree.TreeNode;

class Node17 {
    int val;
    Node17 left;
    Node17 right;

    Node17(int x) {
        val = x;
        left = right = null;
    }
}

public class ConvertSortedArrayToBinarySearchTree {
    public Node17 sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        Node17 head = toBST(nums, 0, nums.length-1);
        return head;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public Node17 toBST(int[] nums, int begin, int end) {
        if(begin>end) return null;
        int mid = (begin + end)/2;
        Node17 head = new Node17(nums[mid]);
        head.left = toBST(nums, begin, mid-1);
        head.right = toBST(nums, mid+1, end);
        return head;
    }
}
