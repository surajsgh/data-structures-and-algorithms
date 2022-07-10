public class MaximumSubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20};
        int n = arr.length;
        System.out.println(maximumSubsequenceSum(arr, n));
    }

    public static int maximumSubsequenceSum(int[] arr, int n) {
        int[] temp = new int[n];

        for (int i=0; i<n; i++) {
            temp[i] = arr[i];
            for (int j=0; j<i; j++) {
                if (arr[j]<arr[i]) {
                    temp[i] = Math.max(temp[i], temp[j] + arr[i]);
                }
            }
        }

        int res = temp[0];
        for (int i=1; i<n; i++) {
            if (res<temp[i]) {
                res = temp[i];
            }
        }

        return res;
    }
}
