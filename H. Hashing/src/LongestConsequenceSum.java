import java.util.Arrays;
import java.util.HashSet;

public class LongestConsequenceSum {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 4, 2, 10, 13};
//        System.out.println(findLongest(arr, arr.length));
        System.out.println(findLongestEfficient(arr, arr.length));
    }

    //  Time Complexity : O(nlogn)
    //  Auxiliary Space : O(1)
    public static int findLongest(int[] arr, int n) {
        if (arr.length==0) {
            return 0;
        }
        int count = 1;
        int result = 0;
        Arrays.sort(arr);
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]+1) {
                count++;
            }
            else if(arr[i]==arr[i-1]) {
                continue;
            }
            else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int findLongestEfficient(int arr[], int n) {
        int count = 0;
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(arr[i]);
        }
        for (int i=0; i<n; i++) {
            if (!set.contains(arr[i]-1)) {
                count = 1;
                while (set.contains(count+arr[i])) {
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
