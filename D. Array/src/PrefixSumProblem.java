import java.util.Arrays;

public class PrefixSumProblem {
    public static void main(String[] args) {
        System.out.println(calcSum(new int[]{2, 8, 3, 9, 6, 5, 4}, 1, 3));
        System.out.println(prefixSumArray(new int[]{2, 8, 3, 9, 6, 5, 4}, 1, 3));
    }

//    Now, In order to find out the prefix sum on a specific index position, You have to use calcSum method.
//    Just use the formula : prefixSum(left) - prefixSum(right-1)
//    Time Complexity : O(n)
//    Auxiliary Space : O(n)
    public static int prefixSumArray(int arr[], int left, int right) {
        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i=1; i<arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        return (prefixSum[right] - prefixSum[left-1]);
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int calcSum(int arr[], int left, int right) {
        int sum = 0;
        for (int i=left; i<=right; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
