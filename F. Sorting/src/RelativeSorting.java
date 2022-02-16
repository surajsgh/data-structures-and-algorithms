import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSorting {
    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(n)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr2) {
            map.put(num, 0);
        }

        int index = arr1.length-1;
        int[] res = new int[arr1.length];
        for (int num : arr1) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else {
                res[index--] = num;
            }
        }

        int p = 0;
        for (int num : arr2) {
            int k = map.get(num);
            for(int i=0; i<k; i++) {
                res[p++] = num;
            }
        }

        Arrays.sort(res, p, res.length);
        return res;
    }
}
