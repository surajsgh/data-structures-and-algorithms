class Node3 {
    int key;
    Node3 left;
    Node3 right;

    Node3(int x) {
        key = x;
        left = right = null;
    }
}

public class DeleteOperation {
    public static void main(String[] args) {
        Node3 root=new Node3(10);
        root.left=new Node3(5);
        root.right=new Node3(15);
        root.right.left=new Node3(12);
        root.right.right=new Node3(18);
        root = delete(root, 15);
        inorder(root);
    }

    //  Time Complexity : O(h)
    //  Auxiliary Space : O(h)
    public static Node3 delete(Node3 root, int x) {
        if (root==null) {
            return null;
        }
        if (root.key<x) {
            root.right = delete(root.right, x);
        }
        else if (root.key>x) {
            root.left = delete(root.left, x);
        }
        else {
            if (root.left==null) {
                return root.right;
            }
            else if (root.right==null) {
                return root.left;
            }
            else {
                Node3 succ = getSuccessor(root);
                root.key = succ.key;
                root.right = delete(root.right, succ.key);
            }
        }
        return root;
    }

    public static Node3 getSuccessor(Node3 root) {
        Node3 curr = root.right;
        while (curr!=null && curr.left!=null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void inorder(Node3 root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
}

