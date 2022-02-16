class Node18 {
    int data;
    Node18 left;
    Node18 right;

    Node18(int x) {
        data = x;
        left = right = null;
    }
}

public class InOrderSuccessor {
    //  Time Complexity : O(h)
    //  Auxiliary Space : O(1)
    public Node18 inorderSuccessor(Node18 root,Node18 x) {
        if(root==null) return null;

        Node18 successor = null;

        while(root!=null) {
            if(x.data<root.data) {
                successor = root;
                root = root.left;
            }
            else if(x.data>root.data) {
                root = root.right;
            }
            else {
                if(root.right!=null) {
                    successor = getSuccessor(root);
                }
                break;
            }
        }

        return root != null ? successor : null;
    }

    public Node18 getSuccessor(Node18 root) {
        if(root==null) return null;

        Node18 curr = root.right;

        while(curr.left!=null) {
            curr = curr.left;
        }

        return curr;
    }
}
