import java.util.LinkedList;
import java.util.Queue;

class Node8 {
    int key;
    Node8 left;
    Node8 right;
    
    Node8 (int x) {
        key = x;
        left=right=null;
    }
}

public class LevelOrderTraversalLineByLine {
    public static void main(String[] args) {
        Node8 root = new Node8(10);
        root.left = new Node8(20);
        root.right = new Node8(30);
        root.right.left = new Node8(25);
        root.right.right = new Node8(35);
        print(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(w)
    public static void print(Node8 root) {
        Queue<Node8> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node8 curr = queue.poll();
                System.out.print(curr.key + " ");
                if (curr.left!=null) {
                    queue.add(curr.left);
                }
                if (curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }
    }
}
