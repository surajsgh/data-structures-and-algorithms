public class SearchInsertPosition {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(target>nums[n-1]) {
                return n;
            }
            else if(target>nums[i] && target<nums[i+1]) {
                return i+1;
            }
            else if(target==nums[i]) {
                return i;
            }
        }
        return 0;
    }

    //  Time Complexity : O(log(n))
    //  Auxiliary Space : O(1)
    public int searchInsertEfficient(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
