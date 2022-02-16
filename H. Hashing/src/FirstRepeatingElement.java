import java.util.HashSet;

public class FirstRepeatingElement {
    //  In the naive approach, just use the nested loops and as soon as you find the repeating element, break the loop and return the repe
    //  -ating element.
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int firstRepeatedElementEfficient(int[] arr, int n) {
        int min = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i=arr.length-1; i>=0; i--) {
            if (set.contains(arr[i])) {
                min = i;
            }
            else {
                set.add(arr[i]);
            }
        }
        if (min != -1) {
            return min + 1;
        }
        else {
            return -1;
        }
    }
}
