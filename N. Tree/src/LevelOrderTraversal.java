import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node7 {
    Node7 left;
    Node7 right;
    int key;

    Node7(int x) {
        key = x;
        left = right = null;
    }
}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node7 root = new Node7(10);
        root.left = new Node7(20);
        root.right = new Node7(30);
        root.right.left = new Node7(25);
        root.right.right = new Node7(35);
        levelOrderTraversal(root);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(w)
    public static void levelOrderTraversal(Node7 root) {
        if (root==null) {
            return;
        }
        Queue<Node7> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node7 curr = queue.poll();
            System.out.println(curr.key + " ");
            if (curr.left!=null) {
                queue.add(curr.left);
            }
            if (curr.right!=null) {
                queue.add(curr.right);
            }
        }

//        public List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> list = new LinkedList<>();
//            Queue<TreeNode> queue = new LinkedList<>();
//            if(root==null) return list;
//            queue.add(root);
//            while(!queue.isEmpty()) {
//                int size = queue.size();
//                List<Integer> queueList = new LinkedList<>();
//                for(int i=0; i<size; i++) {
//                    TreeNode element = queue.poll();
//                    queueList.add(element.val);
//                    if(element.left!=null) {
//                        queue.add(element.left);
//                    }
//                    if(element.right!=null) {
//                        queue.add(element.right);
//                    }
//                }
//                list.add(queueList);
//            }
//            return list;
//        }
    }
}
