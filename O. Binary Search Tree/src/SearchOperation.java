class Node {
    int key;
    Node left;
    Node right;

    Node(int x) {
        key = x;
        left = right = null;
    }
}

public class SearchOperation {
    public static void main(String[] args) {
        Node root=new Node(15);
        root.left=new Node(5);
        root.left.left=new Node(3);
        root.right=new Node(20);
        root.right.left=new Node(18);
        root.right.left.left=new Node(16);
        root.right.right=new Node(80);
        if (searchIterative(root, 3)) {
            System.out.print("Found!");
        }
        else {
            System.out.print("It's not here.");
        }
    }

    //  Recursive
    //  Time Complexity : O(h)
    //  Auxiliary Space : O(h)
    public static boolean searchRecursive(Node root, int x) {
        if (root==null) {
            return false;
        }
        if (root.key==x) {
            return true;
        }
        if (root.key>x) {
            return searchRecursive(root.left, x);
        }
        else {
            return searchRecursive(root.right, x);
        }
    }

    //  Iterative
    //  Time Complexity : O(h)
    //  Auxiliary Space : O(1)
    public static boolean searchIterative(Node root, int x) {
        while (root!=null) {
            if (root.key==x) {
                return true;
            }
            if (root.key>x) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return false;
    }
}
