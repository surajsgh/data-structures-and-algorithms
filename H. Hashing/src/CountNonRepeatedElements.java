import java.util.HashMap;
import java.util.Map;

public class CountNonRepeatedElements {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static long countNonRepeated(int arr[], int n)
    {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                count++;
            }
        }
        return count;
    }
}
