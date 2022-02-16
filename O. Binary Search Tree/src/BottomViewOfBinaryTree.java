import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node12 {
    int val;
    Node12 left;
    Node12 right;

    Node12(int x) {
        val = x;
        left = right = null;
    }
}

class Pair3 {
    Node12 node;
    int hd;

    Pair3(Node12 n, int h) {
        node = n;
        hd = h;
    }
}

public class BottomViewOfBinaryTree {
    public static void main(String[] args) {
        Node12 root = new Node12(10);
        root.left = new Node12(20);
        root.right = new Node12(30);
        root.left.left = new Node12(40);
        root.left.right = new Node12(50);
        bottomView(root);
    }

    public static void bottomView(Node12 root) {
        Queue<Pair3> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.add(new Pair3(root, 0));
        while (!queue.isEmpty()) {
            Pair3 pair = queue.poll();
            Node12 node = pair.node;
            int hd = pair.hd;
            map.put(hd, node.val);
            if (node.left!=null) queue.add(new Pair3(node.left, hd-1));
            if (node.right!=null) queue.add(new Pair3(node.right, hd+1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
