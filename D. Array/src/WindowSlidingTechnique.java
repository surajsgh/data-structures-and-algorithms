public class WindowSlidingTechnique {
    public static void main(String[] args) {
        System.out.println(findTheMaxSum(new int[]{1, 8, 30, -5, 20, 7}, 3));
    }

//    Time Complexity : O((n-k)*(n+k-1))
//    Auxiliary Space : O(1)
    public static int findTheMaxSum(int arr[], int k) {
        int res=0;
        int sum=0;
        for (int i=0; i<=arr.length-k; i++) {
            for (int j=i; j<=i+k-1; j++) {
                sum += arr[j];
            }
            res = Math.max(res, sum);
            sum=0;
        }
        return res;
    }

//    Time Complexity : O(n);
//    Auxiliary Space : O(1)
    public static int findTheMaxSumEfficient(int arr[], int k) {
        int currSum = 0;
        for (int i=0; i<k; i++) {
            currSum += arr[i];
        }
        int maxSum = currSum;
        for (int i=k; i<arr.length; i++) {
            currSum += (arr[i]-arr[i-k]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
