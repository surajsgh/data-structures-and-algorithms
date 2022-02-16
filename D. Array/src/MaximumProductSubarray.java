import java.util.Arrays;

public class MaximumProductSubarray {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int max(int[] arr) {
        if (arr.length==0 || arr==null) {
            return 0;
        }
        int max = arr[0];
        int min = arr[0];
        int res = arr[0];
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int temp = max;
            max = Math.max(Math.max(max*arr[i], min*arr[i]), arr[i]);
            min = Math.min(Math.min(temp*arr[i], min*arr[i]), arr[i]);
            if (res<max) {
                res = max;
            }
        }
        return res;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        for(int i=0; i<n; i++) {
            int curr = nums[i];
            for(int j=i+1; j<n; j++) {
                result = Math.max(result, curr);
                curr *= nums[j];
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}
