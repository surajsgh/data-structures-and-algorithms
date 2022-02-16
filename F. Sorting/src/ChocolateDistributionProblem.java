import java.lang.reflect.Array;
import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 3, 2, 4, 9, 12, 56};
        System.out.println(minDiff(arr, 3));
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(1)
    public static int minDiff(int arr[], int m) {
        int n = arr.length;
        if (m>n) {
            return -1;
        }
        Arrays.sort(arr);
        int result = arr[m-1]-arr[0];
        for (int i=0; i+m-1<n; i++) {
            result = Math.min(result, arr[i+m-1]-arr[i]);
        }
        return result;
    }
}
