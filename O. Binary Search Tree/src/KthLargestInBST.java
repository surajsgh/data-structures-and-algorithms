public class KthLargestInBST {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    /*
    int count = 0;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        if(root==null) return -1;
        int right = kthLargest(root.right, K);
        if(right!=-1) return right;
        count++;
        if(count==K) return root.data;
        return kthLargest(root.left, K);
    }

     */
}
