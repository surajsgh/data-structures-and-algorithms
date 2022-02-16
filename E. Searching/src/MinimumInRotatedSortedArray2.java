public class MinimumInRotatedSortedArray2 {
    //  Time Complexity : O(log(n))
    //  Auxiliary Space : O(1)
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]<nums[high]) {
                high = mid;
            }
            else if(nums[mid]>nums[high]) {
                low = mid + 1;
            }
            else {
                high--;
            }
        }
        return nums[low];
    }
}
