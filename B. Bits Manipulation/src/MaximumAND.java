public class MaximumAND {
    public static void main(String[] args) {
        int[] arr = {4, 8, 16, 2};
        int n = arr.length;
        System.out.println("Maximum AND value: " + maxAND(arr, n));
    }

    public static int checkCount(int pattern, int arr[], int n) {
        int count = 0;
        for (int i=0; i<n; i++) {
            if ((pattern & arr[i])==pattern) {
                count++;
            }
        }
        return count;
    }

    //  Time Complexity : O(nlog(m)) where m is the maximum value from the array
    //  Auxiliary Space : O(1)
    public static int maxAND(int[] arr, int n) {
        int result = 0;
        int count;
        for (int i=31; i>=0; i--) {
            count = checkCount((result | 1<<i), arr, n);
            if (count >= 2) {
                result |= 1<<i;
            }
        }
        return result;
    }
}
