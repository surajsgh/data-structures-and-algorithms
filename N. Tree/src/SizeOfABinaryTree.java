import javax.swing.tree.TreeNode;

class Node9 {
    int key;
    Node9 left;
    Node9 right;

    Node9 (int x) {
        key = x;
        left=right=null;
    }
}

public class SizeOfABinaryTree {
    public static void main(String[] args) {
        Node9 root = new Node9(10);
        root.left = new Node9(20);
        root.right = new Node9(30);
        root.right.left = new Node9(25);
        root.right.right = new Node9(35);
        System.out.println(height(root));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static int height(Node9 root) {
        if (root==null) {
            return 0;
        }
        else {
            return (height(root.left)+height(root.right)+1);
        }
    }

    //  Time Complexity : O(logn*logn)
    //  Auxiliary Space : O(h)
    public int countNodes(Node9 root) {
        int lh = 0;
        int rh = 0;
        Node9 curr = root;
        while(curr!=null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr!=null) {
            rh++;
            curr = curr.right;
        }
        if(lh==rh) {
            return ((int) Math.pow(2, lh)-1);
        }
        else {
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}
