import java.util.ArrayList;
import java.util.Collections;

public class LaptopRentals {
    //  Time Complexity : O(nlogn)
    //  Auxiliary Space : O(n)
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        ArrayList<Integer> starts = new ArrayList<Integer>();
        ArrayList<Integer> ends = new ArrayList<Integer>();
        int needs = 0;

        for(ArrayList<Integer> list : times) {
            starts.add(list.get(0));
            ends.add(list.get(1));
        }

        Collections.sort(starts);
        Collections.sort(ends);

        int startIndex = 0;
        int endIndex = 0;

        while(startIndex < times.size()) {
            if(starts.get(startIndex) >= ends.get(endIndex)) {
                needs--;
                endIndex++;
            }
            startIndex++;
            needs++;
        }
        return needs;
    }
}
