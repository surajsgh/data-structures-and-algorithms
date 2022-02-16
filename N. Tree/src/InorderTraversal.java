import java.util.Stack;

class Node2 {
    int key;
    Node2 left;
    Node2 right;

    Node2(int x) {
        key = x;
        left=right=null;
    }
}

public class InorderTraversal {
    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left = null;
        root.right = new Node2(2);
        root.right.left = new Node2(3);
        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void inOrderRecursive(Node2 root) {
        if (root!=null) {
            inOrderRecursive(root.left);
            System.out.print(root.key + " ");
            inOrderRecursive(root.right);
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void inOrderIterative(Node2 root) {
        Stack<Node2> stack = new Stack<Node2>();
        Node2 curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
}
