class Node16 {
    int key;
    Node16 left;
    Node16 right;

    Node16(int x) {
        key = x;
        left = right = null;
    }
}

public class ConstructBinaryTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        int in[]={20,10,40,30,50};
        int pre[]={10,20,30,40,50};
        int n = in.length;
        Node16 root = constructTree(in, pre, 0, n-1);
        inOrder(root);
    }

    public static void inOrder(Node16 root) {
        if (root!=null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(n)
    static int index = 0;
    public static Node16 constructTree(int[] inOrder, int[] preOrder, int start, int end) {
        if (start>end) return null;
        Node16 root = new Node16(preOrder[index++]);
        int breakPoint = start;
        for (int i=start; i<=end; i++) {
            if (inOrder[i]==root.key) {
                breakPoint = i;
                break;
            }
        }
        root.left = constructTree(inOrder, preOrder, start, breakPoint-1);
        root.right = constructTree(inOrder, preOrder, breakPoint+1, end);
        return root;
    }
}
