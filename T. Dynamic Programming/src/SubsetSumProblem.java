import java.util.Arrays;

public class SubsetSumProblem {
    static int[][] memo;
    public static void main(String[] args) {
        int[] nums = { 1, 5, 3, 7, 4 };
        System.out.println(subsetSum(nums, nums.length, 12));
        memo = new int[nums.length+1][13];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        System.out.println(subsetSumDP(nums, nums.length, 12));
    }

    public static int subsetSumDP(int[] nums, int n, int sum) {
        System.out.println( Arrays.toString(nums) + " " + n + " " + sum);
        if (n==0) {
            return sum==0 ? 1:0;
        }
        if (sum<0) {
            return 0;
        }
        if (memo[n][sum]==-1) {
            memo[n][sum] = subsetSumDP(nums, n-1, sum) + subsetSumDP(nums, n-1, sum-nums[n-1]);
        }
        return memo[n][sum];
    }

    public static int subsetSum(int[] nums, int n, int sum) {
        if (n==0) {
            return sum==0? 1:0;
        }
        return subsetSum(nums, n-1, sum) + subsetSum(nums, n-1, sum-nums[n-1]);
    }
}
