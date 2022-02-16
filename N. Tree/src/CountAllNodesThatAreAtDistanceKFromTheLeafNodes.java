class Node30 {
    int val;
    Node30 left;
    Node30 right;

    Node30(int val) {
        val = val;
        left = right = null;
    }
}

public class CountAllNodesThatAreAtDistanceKFromTheLeafNodes {
    int count=0;
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node30 root, int k)
    {
        // Write your code here
        int[] elements = new int[1000];
        boolean[] visited = new boolean[1000];
        helper(root, elements, visited, k, 0);
        return count;
    }

    void helper(Node30 root, int[] elements, boolean[] visited, int k, int index) {
        if(root==null) return;

        elements[index] = root.val;
        visited[index] = false;
        index++;

        if(root.left==null && root.right==null && index-k-1>=0 && visited[index-k-1]==false) {
            count++;
            visited[index-k-1]=true;
            return;
        }

        helper(root.left, elements, visited, k, index);
        helper(root.right, elements, visited, k, index);
    }

}
