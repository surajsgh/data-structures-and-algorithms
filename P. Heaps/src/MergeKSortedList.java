import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Triplet implements Comparable<Triplet> {
    int val, aPos, vPos;

    Triplet(int v, int ap, int vp) {
        val = v;
        aPos = ap;
        vPos = vp;
    }

    public int compareTo(Triplet t) {
        if (val < t.val) return -1;
        return 1;
    }
}

public class MergeKSortedList {
    //  Time Complexity : O(nklognk)
    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> helperList : list) {
            for (int element : helperList) {
                result.add(element);
            }
        }

        Collections.sort(result);
        return result;
    }

    //  Time Complexity : O(nklogk)
    //  Auxiliary Space : O(k)
    public static ArrayList<Integer> mergeEff(ArrayList<ArrayList<Integer>> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Triplet> queue = new PriorityQueue<Triplet>();

        for (int i=0; i<list.size(); i++) {
            queue.add(new Triplet(list.get(i).get(0), i, 0));
        }

        while (!queue.isEmpty()) {
            Triplet curr = queue.poll();
            result.add(curr.val);
            int ap = curr.aPos;
            int vp = curr.vPos;
            if (vp+1 < list.get(ap).size()) {
                queue.add(new Triplet(list.get(ap).get(vp+1), ap, vp+1));
            }
        }

        return result;
    }
}
