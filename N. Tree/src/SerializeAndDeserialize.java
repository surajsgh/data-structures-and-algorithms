import java.util.ArrayList;

class Node20 {
    int key;
    Node20 left;
    Node20 right;

    Node20(int x) {
        key = x;
        left = right = null;
    }
}

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        Node20 root = new Node20(1);
        root.left = new Node20(2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        serialize(root, arrayList);
        for (int x : arrayList) {
            System.out.print(x + " ");
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    public static void serialize(Node20 root, ArrayList<Integer> arrayList) {
        if (root==null) {
            arrayList.add(-1);
            return;
        }
        arrayList.add(root.key);
        serialize(root.left, arrayList);
        serialize(root.right, arrayList);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(h)
    static int index = 0;
    public static Node20 deSerialize(ArrayList<Integer> arrayList) {
        int value = arrayList.get(index++);
        if (value == -1) return null;
        Node20 root = new Node20(value);
        root.left = deSerialize(arrayList);
        root.right = deSerialize(arrayList);
        return root;
    }
}
