import java.util.*;

public class SortArrayByItsFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list, (a, b) -> {
            return (map.get(a)==map.get(b)) ? b-a : map.get(a)-map.get(b);
        });

        int[] res = new int[nums.length];
        int i = 0;
        for (int num : list) {
            for (int j = 0; j < map.get(num); j++) {
                res[i++] = num;
            }
        }
        return res;
    }
}
