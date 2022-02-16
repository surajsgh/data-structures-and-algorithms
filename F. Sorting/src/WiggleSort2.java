import java.util.Arrays;

// Wave sort
public class WiggleSort2 {
    //  Time Complexity : O(nlogn)
    //  Auxiliary Space : O(n)
    public static void sort(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        Arrays.sort(arr);
        int index = n-1;
        for (int i=1; i<n; i+=2) {
            nums[i] = arr[index--];
        }
        for (int i=0; i<n; i+=2) {
            nums[i] = arr[index--];
        }
    }
}
