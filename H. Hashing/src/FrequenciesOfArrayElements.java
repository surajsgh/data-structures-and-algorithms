import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfArrayElements {
    public static void main(String[] args) {
        int[] arr = new int[]{50, 50, 10, 40, 40};
        countFreq(arr);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void countFreq(int[] arr) {
        HashMap<Integer, Integer> keyValues = new HashMap<Integer, Integer>();
        for (int i : arr) {
            keyValues.put(i, keyValues.getOrDefault(i, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : keyValues.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
