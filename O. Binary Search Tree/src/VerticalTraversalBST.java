import com.sun.source.tree.Tree;

import java.util.*;

class Node10 {
    int val;
    Node10 left;
    Node10 right;

    Node10(int x) {
        val = x;
        left = right = null;
    }
}

class Pair {
    Node10 node;
    int hd;

    Pair(Node10 n, int h) {
        node=n;
        hd=h;
    }
}

public class VerticalTraversalBST {
    public static void main(String[] args) {
        Node10 root = new Node10(10);
        root.left = new Node10(20);
        root.right = new Node10(30);
        root.left.left = new Node10(40);
        root.left.right = new Node10(50);
        verticalTraversal(root);
    }

    //  Time Complexity : O(nlog(hd))
    //  Auxiliary Space : O(hd + h)
    public static void verticalTraversal(Node10 root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node10 curr = pair.node;
            int hd = pair.hd;
            if (map.containsKey(hd)) {
                map.get(hd).add(curr.val);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.val);
                map.put(hd, list);
            }
            if (curr.left!=null) queue.add(new Pair(curr.left, hd-1));
            if (curr.right!=null) queue.add(new Pair(curr.right, hd+1));
        }
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()) {
            ArrayList<Integer> arr = m.getValue();
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
