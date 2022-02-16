import java.util.Stack;

class Node4 {
    int key;
    Node4 left;
    Node4 right;

    Node4(int x) {
        key = x;
        left=right=null;
    }
}

public class PostOrderTraversal {
    public static void main(String[] args) {
        Node4 root = new Node4(10);
        root.left = new Node4(20);
        root.right = new Node4(30);
        root.right.left = new Node4(25);
        root.right.right = new Node4(35);
        postOrder(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void postOrder(Node4 root) {
        if (root!=null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void postOrderIterative(Node4 root) {
        Stack<Node4> stack = new Stack<>();
        while (true) {
            while (root!=null) {
                stack.add(root);
                stack.add(root);
                root = root.left;
            }

            if (stack.isEmpty()) return;

            root = stack.pop();

            if (!stack.isEmpty() && root==stack.peek()) {
                root = root.right;
            }
            else {
                System.out.print(root + " ");
                root=null;
            }
        }
    }
}
