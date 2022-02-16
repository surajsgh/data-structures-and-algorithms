public class MaximumCircularSubArray {
    public static void main(String[] args) {
        System.out.println(overallMaxSum(new int[]{8, -4, 3, -5, 4}));
    }

//     Kadane's algorithm
    public static int normalMaxSum(int arr[]) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i=1; i<arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int overallMaxSum(int arr[]) {
        int maxNormal = normalMaxSum(arr);
        if (maxNormal < 0) {
            return maxNormal;
        }
        int arrSum = 0;
        for (int i=0; i<arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCircular = arrSum + normalMaxSum(arr);
        return Math.max(maxCircular, maxNormal);
    }
}
