public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(totalCombinationSum(arr, arr.length, 4));
    }

    //  Time Complexity : O(2^n)
    //  Auxiliary Space : O(2^n)
    public static int totalCombinationSum(int[] arr, int n, int sum) {
        if (sum==0) return 1;
        if (n==0) return 0;
        int res = totalCombinationSum(arr, n-1, sum);
        if (arr[n-1]<=sum) {
            res += totalCombinationSum(arr, n, sum-arr[n-1]);
        }
        return res;
    }
}
