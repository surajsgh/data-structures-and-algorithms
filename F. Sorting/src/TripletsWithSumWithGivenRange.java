import java.util.Arrays;

public class TripletsWithSumWithGivenRange {
    public static void main(String[] args) {
        int[] arr = {2, 7, 5, 3, 8, 4, 1, 9};
        int n = arr.length;
        int low = 8;
        int high = 16;
        System.out.println(result(arr, n, low, high));
    }

    //  Time Complexity : O(n**2)
    //  Auxiliary Space : O(1)
    public static int countTriplets(int[] arr, int n, int val) {
        Arrays.sort(arr);
        int sum = 0;
        int ans = 0;
        for (int i=0; i<n-2; i++) {
            int low = i+1;
            int high = arr.length-1;
            while (low!=high) {
                sum = arr[i] + arr[low] + arr[high];
                if (sum>val) {
                    high--;
                }
                else {
                    ans += (high-low);
                    low++;
                }
            }
        }
        return ans;
    }

    public static int result(int[] arr, int n, int low, int high) {
        int res = 0;
        res = countTriplets(arr, arr.length, high)-countTriplets(arr, arr.length, low-1);
        return res;
    }
}
