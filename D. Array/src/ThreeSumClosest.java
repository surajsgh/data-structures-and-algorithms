import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int threeSumClosest(int[] nums, int target) {
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
