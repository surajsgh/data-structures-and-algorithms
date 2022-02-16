import java.util.LinkedList;
import java.util.Queue;

class Node24 {
    int key;
    Node24 left;
    Node24 right;
    Node24 next;

    Node24(int val) {
        key = val;
        left = right =  next = null;
    }
}

public class ConnectNodesAtTheSameLevel {
    //  This solution works fine for both, complete and incomplete binary trees.
    //  Iterative
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(w)
    public Node24 connectIterative(Node24 root) {
        if(root==null) return null;
        Queue<Node24> queue = new LinkedList<>();
        queue.add(root);
        Node24 curr = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node24 prev = curr;
                curr = queue.poll();
                if(i>0) {
                    prev.next = curr;
                }
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            curr.next = null;
        }
        return root;
    }

    //  Recursive
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public Node24 connect(Node24 root) {
        if(root==null) return null;

        if(root.left!=null) {
            root.left.next = root.right;
        }

        if(root.right!=null && root.next!=null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
}
