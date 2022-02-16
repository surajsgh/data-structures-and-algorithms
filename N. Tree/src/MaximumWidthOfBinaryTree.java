import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Node14 {
    int key;
    Node14 left;
    Node14 right;

    Node14 (int x) {
        key = x;
        left = right = null;
    }
}

public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Node14 root = new Node14(10);
        root.left = new Node14(20);
        root.right = new Node14(30);
        root.right.left = new Node14(25);
        root.right.right = new Node14(35);
        System.out.println(widthOfBinaryTree(root));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(w)
    public static int widthOfBinaryTree(Node14 root) {
        if(root==null) {
            return 0;
        }
        int res = 0;
        Queue<Node14> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i=0; i<count; i++) {
                Node14 curr = queue.poll();
                if(curr.left!=null) {
                    queue.add(curr.left);
                }
                if(curr.right!=null) {
                    queue.add(curr.right);
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /*
    //  Leetcode version
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.offer(root);
        int currentWidth = 0;
        int maxWidth = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            int start = 0;
            int end = 0;

            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                if(i==0) start = map.get(curr);
                if(i==size-1) end = map.get(curr);
                if(curr.left!=null) {
                    map.put(curr.left, 2*map.get(curr));
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    map.put(curr.right, 2*map.get(curr)+1);
                    queue.offer(curr.right);
                }
            }

            currentWidth = end-start+1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }

        return maxWidth;
    }
     */
}
