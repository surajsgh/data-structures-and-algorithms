class Node25 {
    int key;
    Node25 left;
    Node25 right;

    Node25(int val) {
        key = val;
        left = right = null;
    }
}

public class ContsructBinaryTreeFromParentArray {
    static Node25 root;
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static Node25 createTree(int parent[], int N)
    {
        Node25[] created = new Node25[N];
        for(int i=0; i<N; i++) {
            created[i] = null;
        }
        for(int i=0; i<N; i++) {
            helper(parent, i, created);
        }
        return root;
    }

    public static void helper(int parent[], int i, Node25 created[]) {
        if(created[i]!=null) return;

        created[i] = new Node25(i);

        if(parent[i]==-1) {
            root = created[i];
            return;
        }

        if(created[parent[i]]==null) {
            helper(parent, parent[i], created);
        }

        Node25 node = created[parent[i]];

        if(node.left==null) {
            node.left=created[i];
        }
        else {
            node.right=created[i];
        }
    }
}
