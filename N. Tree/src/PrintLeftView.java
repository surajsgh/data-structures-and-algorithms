import java.util.LinkedList;
import java.util.Queue;

class Node11 {
    int key;
    Node11 left;
    Node11 right;

    Node11 (int x) {
        key = x;
        left=right=null;
    }
}

public class PrintLeftView {
    public static void main(String[] args) {
        Node11 root = new Node11(10);
        root.left = new Node11(20);
        root.right = new Node11(30);
        root.right.left = new Node11(25);
        root.right.right = new Node11(35);
        printView(root);
        System.out.println();
        printIteratively(root);
    }

    static int maxLevel = 0;
    public static void print(Node11 root, int level) {
        if (root==null) return;
        if (level>maxLevel) {
            System.out.print(root.key + " ");
            maxLevel=level;
        }
        print(root.left, level+1);
        print(root.right, level+1);
    }

    //  Recursively
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void printView(Node11 root) {
        print(root, 1);
    }

    //  Iteratively
    //  Time Complexity : O(n)
    //  Auxiliary Sum : O(w)
    public static void printIteratively(Node11 root) {
        if (root==null) return;
        Queue<Node11> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node11 curr = queue.poll();
                if (i==0) {
                    System.out.print(curr.key + " ");
                }
                if (curr.left!=null) {
                    queue.add(curr.left);
                }
                if (curr.right!=null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}
