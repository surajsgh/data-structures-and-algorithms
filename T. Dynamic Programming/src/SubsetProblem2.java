import java.util.Arrays;

public class SubsetProblem2 {
    static boolean[][] memo;
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 4;
        memo = new boolean[nums.length+1][target+1];
        for (int i=0; i<=nums.length; i++) {
            Arrays.fill(memo[i], false);
        }
        System.out.println(subsetSum(nums, target, nums.length));
        System.out.println(subsetSumEff(nums, target, nums.length));
    }

    public static boolean subsetSum(int[] nums, int target, int n) {
        if (n==0) {
            return target==0;
        }
        boolean unPicked = subsetSum(nums, target, n-1);
        boolean picked = subsetSum(nums, target-nums[n-1], n-1);
        return unPicked || picked;
    }

    public static boolean subsetSumEff(int[] nums, int target, int n) {
        if (n==0) {
            return target==0;
        }
        if (memo[nums.length][target]) return memo[nums.length][target];
        boolean unPicked = subsetSum(nums, target, n-1);
        boolean picked = subsetSum(nums, target-nums[n-1], n-1);
        return memo[nums.length][target] = unPicked || picked;
    }
}
