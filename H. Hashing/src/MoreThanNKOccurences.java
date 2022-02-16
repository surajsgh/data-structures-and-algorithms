import java.util.HashMap;
import java.util.Map;

public class MoreThanNKOccurences {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10, 10};
        printCount(arr, arr.length, 2);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void printCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getValue()>(n/k)) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
