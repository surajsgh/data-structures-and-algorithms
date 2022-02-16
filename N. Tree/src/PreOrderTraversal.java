import java.util.LinkedList;
import java.util.Stack;

class Node3 {
    int key;
    Node3 left;
    Node3 right;

    Node3(int x) {
        key = x;
        left=right=null;
    }
}

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node2 root = new Node2(10);
        root.left = new Node2(20);
        root.right = new Node2(30);
        root.right.left = new Node2(25);
        root.right.right = new Node2(35);
        preOrderIterative(root);
        System.out.println();
        preOrderRecursive(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void preOrderIterative(Node2 root) {
        if (root==null) {
            return;
        }
        Stack<Node2> stack = new Stack<Node2>();
        stack.add(root);
        Node2 curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr!=null) {
                System.out.print(curr.key + " ");
                if (curr.right!=null) {
                    stack.add(curr.right);
                }
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void preOrderRecursive(Node2 root) {
        if (root!=null) {
            System.out.print(root.key + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }
}
