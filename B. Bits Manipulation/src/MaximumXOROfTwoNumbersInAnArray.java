import java.util.HashSet;

public class MaximumXOROfTwoNumbersInAnArray {
    //  Time Complexity : O(n*log(m))
    public static int findMaxXOR(int[] arr) {
        int mask = 0;
        int maxx = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=31; i>=0; i--) {
            mask |= (1<<i);
            for (int j=0; j<arr.length; i++) {
                set.add(mask & arr[i]);
            }

            int newMaxx = maxx | 1<<i;

            for (int prefix : arr) {
                if (set.contains(prefix ^ newMaxx)) {
                    maxx = newMaxx;
                    break;
                }
            }
            set.clear();
        }
        return maxx;
    }
}
