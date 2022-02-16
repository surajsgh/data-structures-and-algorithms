class Node2 {
    int key;
    Node2 left;
    Node2 right;

    Node2(int x) {
        key = x;
        left = right = null;
    }
}

public class InsertOperation {
    public static void main(String[] args) {
        Node2 root=new Node2(10);
        root.left=new Node2(5);
        root.right=new Node2(15);
        root.right.left=new Node2(12);
        root.right.right=new Node2(18);
        root = insertNaive(root, 10);
        inorder(root);
    }

    //  Time Complexity : O(h)
    //  Auxiliary Space : O(1)
    public static Node2 insertEfficient(Node2 root, int x) {
        Node2 temp = new Node2(x);
        Node2 curr = root;
        Node2 parent = null;
        while (curr!=null) {
            parent = curr;
            if (curr.key<x) {
                curr = curr.right;
            }
            else if (curr.key>x) {
                curr = curr.left;
            }
            else {
                return root;
            }
        }
        if (parent==null) {
            return temp;
        }
        if (parent.key<x) {
            parent.right = temp;
        }
        else {
            parent.left = temp;
        }
        return root;
    }

    //  Time Complexity : O(h)
    //  Auxiliary Space : O(h)
    public static Node2 insertNaive(Node2 root, int x) {
        if (root==null) {
            return new Node2(x);
        }
        if (root.key<x) {
            root.right = insertNaive(root.right, x);
        }
        else if (root.key>x){
            root.left = insertNaive(root.left, x);
        }
        return root;
    }

    public static void inorder(Node2 root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
}
