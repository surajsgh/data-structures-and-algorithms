//  Implementation of binary tree.
class Node {
    Node left;
    Node right;
    int key;

    Node(int x) {
        key = x;
        left=right=null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
    }

}
