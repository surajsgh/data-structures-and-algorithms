import java.util.ArrayList;
import java.util.HashSet;

public class FindCommonNodesInTwoBSTs {
    /*
    //  Time Complexity : O(n1+n2)
    //  Auxiliary Space : O(n1+n2)
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        //code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();

        addFirstBSTElements(set, root1);
        checkSet(set, list, root2);

        return list;
    }

    public static void checkSet(HashSet<Integer> set, ArrayList<Integer> list, Node root) {
        if(root!=null) {
            checkSet(set, list, root.left);
            if(set.contains(root.data)) list.add(root.data);
            checkSet(set, list, root.right);
        }
    }

    public static void addFirstBSTElements(HashSet<Integer> set, Node root) {
        if(root!=null) {
            addFirstBSTElements(set, root.left);
            set.add(root.data);
            addFirstBSTElements(set, root.right);
        }
    }

     */
}
