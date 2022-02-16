import java.util.ArrayList;

class Node33 {
    int data;
    Node33 left;
    Node33 right;

    Node33(int val) {
        data = val;
        left = right = null;
    }
}

public class BoundaryTraversalOfBinaryTree {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    ArrayList <Integer> printBoundary(Node33 node)
    {
        ArrayList <Integer> list = new ArrayList<>(0);

        if(node!=null) list.add(node.data);

        printLeftBoundary(node.left, list);
        printLeaves(node.left, list);

        printLeaves(node.right, list);
        printRightBoundary(node.right, list);

        return list;
    }

    void printLeaves(Node33 root, ArrayList <Integer> list) {
        if(root!=null) {
            printLeaves(root.left, list);
            if(root.left==null && root.right==null) {
                list.add(root.data);
            }
            printLeaves(root.right, list);
        }
    }

    void printLeftBoundary(Node33 node, ArrayList<Integer> list) {
        if(node!=null) {
            if(node.left!=null) {
                list.add(node.data);
                printLeftBoundary(node.left, list);
            }
            else if(node.right!=null) {
                list.add(node.data);
                printLeftBoundary(node.right, list);
            }
        }
    }

    void printRightBoundary(Node33 node, ArrayList <Integer> list) {
        if(node!=null) {
            if(node.right!=null) {
                printRightBoundary(node.right, list);
                list.add(node.data);
            }
            else if(node.left!=null) {
                printRightBoundary(node.left, list);
                list.add(node.data);
            }
        }
    }
}
