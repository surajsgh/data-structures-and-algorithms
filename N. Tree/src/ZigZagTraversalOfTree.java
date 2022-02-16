import java.util.Stack;

class Node17 {
    int key;
    Node17 left;
    Node17 right;

    Node17(int x) {
        key = x;
        left = right = null;
    }
}

public class ZigZagTraversalOfTree {
    public static void main(String[] args) {
        Node17 root=new Node17(1);
        root.left=new Node17(2);
        root.right=new Node17(3);
        root.left.left=new Node17(4);
        root.left.right=new Node17(5);
        root.right.left=new Node17(6);
        root.right.right=new Node17(7);
        traverse(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void traverse(Node17 root) {
        if (root==null) return;
        Stack<Node17> stack1 = new Stack<>();
        Stack<Node17> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node17 temp = stack1.peek();
                stack1.pop();

                System.out.print(temp.key + " ");

                if (temp.right!=null) {
                    stack2.add(temp.right);
                }
                if (temp.left!=null) {
                    stack2.add(temp.left);
                }
            }
            while (!stack2.isEmpty()) {
                Node17 temp = stack2.peek();
                stack2.pop();

                System.out.print(temp.key + " ");

                if (temp.left!=null) {
                    stack1.add(temp.left);
                }
                if (temp.right!=null) {
                    stack1.add(temp.right);
                }
            }
        }
    }
}
