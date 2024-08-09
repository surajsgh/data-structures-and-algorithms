//  Partition a set into two subsets such that the difference of subset sums is minimum

import java.util.Arrays;

public class PartitionASetIntoTwoSubsets {
    static int[][] memo;
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};

        int sum = 0;

        for(int num: nums) {
            sum += num;
        }

        memo = new int[nums.length+1][sum+1];

        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        System.out.println(minimumDifference(nums, sum));
    }

    public static int minimumDifference(int[] nums, int sum) {
        int n = nums.length;
        return util(nums, n, 0, sum);
    }

    //  Time Complexity: O(totalSum*n)
    //  Auxiliary Space: O(totalSum*n)
    public static int util(int[] nums, int n, int totalSum, int target) {
        if(n==0) return Math.abs((target-totalSum)-totalSum);
        if (memo[n][totalSum]!=-1) return memo[n][totalSum];
        return memo[n][totalSum] = Math.min(util(nums, n-1, totalSum, target), util(nums, n-1, totalSum + nums[n-1], target));
    }
}
