import java.util.Arrays;

public class ClosestToTheThreeSum {
//    Time Complexity : O(n*n)
//    Auxiliary Space : Depends on the sorting algorithm
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length && result!=0; i++) {
            int low = i+1;
            int high = nums.length-1;
            while(low<high) {
                int sum = nums[low] + nums[high] + nums[i];
                if(Math.abs(target-sum)<Math.abs(result)) {
                    result = target-sum;
                }
                if(sum<target) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }
        return target-result;
    }
}
