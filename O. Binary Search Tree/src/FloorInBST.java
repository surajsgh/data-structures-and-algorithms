class Node4 {
    int key;
    Node4 left;
    Node4 right;

    Node4(int x) {
        key = x;
        left = right = null;
    }
}

public class FloorInBST {
    public static void main(String[] args) {
        Node4 root=new Node4(15);
        root.left=new Node4(5);
        root.left.left=new Node4(3);
        root.right=new Node4(20);
        root.right.left=new Node4(18);
        root.right.left.left=new Node4(16);
        root.right.right=new Node4(80);
        System.out.println(floor(root, 17));
    }

    //  Time Complexity : O(h)
    //  Auxiliary Space : O(1)
    public static int floor(Node4 root, int x) {
        Node4 res = null;
        while (root!=null) {
            if (root.key==x) {
                return root.key;
            }
            else if (root.key<x) {
                res = root;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return res.key;
    }
}
