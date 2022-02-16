import java.util.*;
import java.util.Queue;

class Node11 {
    int val;
    Node11 left;
    Node11 right;

    Node11(int x) {
        val = x;
        left = right = null;
    }
}

class Pair2 {
    Node11 node;
    int hd;
    
    Pair2(Node11 n, int h) {
        node = n;
        hd = h;
    }
}

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        Node11 root = new Node11(10);
        root.left = new Node11(20);
        root.right = new Node11(30);
        root.left.left = new Node11(40);
        root.left.right = new Node11(50);
        topView(root);
    }

    public static void topView(Node11 root) {
        Queue<Pair2> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair2(root, 0));
        while (!queue.isEmpty()) {
            Pair2 pair = queue.poll();
            Node11 node = pair.node;
            int hd = pair.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }
            if (node.left!=null) queue.add(new Pair2(node.left, hd-1));
            if (node.right!=null) queue.add(new Pair2(node.right, hd+1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
