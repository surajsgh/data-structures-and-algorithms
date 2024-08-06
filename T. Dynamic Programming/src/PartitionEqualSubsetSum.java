import java.util.*;

public class PartitionEqualSubsetSum {
    static boolean[][] memo;
    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(canPartition(nums));
    }

    //  Time Complexity: O(n*sum)
    //  Auxiliary Space: O(n*sum)
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums) {
            sum += num;
        }

        if(sum%2==1) return false;

        memo = new boolean[n+1][(sum/2)+1];
        for(boolean[] arr: memo) {
            Arrays.fill(arr, false);
        }

        return util(nums, n, sum/2);
    }

    public static boolean util(int[] nums, int n, int target) {
        if(n==0) return target == 0;
        if(target<0) return false;
        if(memo[n][target]) return memo[n][target];
        return memo[n][target] = util(nums, n-1, target) || util(nums, n-1, target-nums[n-1]);
    }
}
