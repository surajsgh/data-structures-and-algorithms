public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(totalCombinationSum(arr, arr.length, 4));
        System.out.println(totalCombinationSumEff(arr, arr.length, 4));
    }

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(mn)
    public static int totalCombinationSumEff(int[] arr, int n, int sum) {
        int[][] matrix = new int[sum+1][n+1];
        for (int i=0; i<=sum; i++) {
            matrix[i][0] = 0;
        }

        for (int i=1; i<=n; i++) {
            matrix[0][i] = 1;
        }

        for (int i=1; i<=sum; i++) {
            for (int j=1; j<=n; j++) {
                matrix[i][j] = matrix[i][j-1];
                if (arr[j-1]<=i) {
                    matrix[i][j] += matrix[i-arr[j-1]][j];
                }
            }
        }

        return matrix[sum][n];
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
