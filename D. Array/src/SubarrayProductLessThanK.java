public class SubarrayProductLessThanK {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int prod = 0;
        for(int i=0; i<n; i++) {
            if(nums[i]<k) {
                count++;
            }
            prod = nums[i];
            for(int j=i+1; j<n; j++) {
                prod *= nums[j];
                if(prod<k) {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        return count;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int numSubarrayProductLessThanKEfficient(int[] nums, int k) {
        if (k<=1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        int n = nums.length;
        for (int right=0; right<n; right++) {
            prod *= nums[right];
            while (prod>=k) {
                prod /= nums[left++];
            }
            ans += right-left+1;
        }
        return ans;
    }
}
