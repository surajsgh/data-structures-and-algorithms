public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] nums = {2, 5, 3};
        System.out.println(subsetSum(nums, nums.length, 5));
    }

    public static int subsetSum(int[] nums, int n, int sum) {
        if (n==0) {
            return sum==0? 1:0;
        }
        return subsetSum(nums, n-1, sum) + subsetSum(nums, n-1, sum-nums[n-1]);
    }
}
