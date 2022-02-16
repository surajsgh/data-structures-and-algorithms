// Write a program to find the maximum sum of the subarray or Write a program to implement kadane's algorithm.
public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1, -2, 3, -1, 2}));
        System.out.println(maxSumKadaneAlgo(new int[]{-3, 8, -2, 4, -5, 6}));
    }

//    Time Complexity : O(n^2)
//    Auxiliary Space : O(1)
    public static int maxSum(int arr[]) {
        int res = arr[0];
        for (int i=0; i<arr.length; i++) {
            int curr = 0;
            for (int j=i; j<arr.length; j++) {
                curr = curr + arr[j];
                res = Math.max(res, curr);
            }
        }
        return res;
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
//    Kadane's Algorithm
    public static int maxSumKadaneAlgo(int arr[]) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i=1; i<arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }
}
