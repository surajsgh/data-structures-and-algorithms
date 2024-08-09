public class CountPartitionsWithGivenDifference {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 4};
        int sum = sum(nums);
        int diff = 3;
        if (sum-diff<0 || (sum-diff)%2==1) {
            System.out.println("Zero count...");
        }

        System.out.println(countPartitions(nums, nums.length, (sum-diff)/2, 0));
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }

    public static int countPartitions(int[] nums, int n, int target, int currSum) {
        if (currSum==target) return 1;
        if (n==0) return 0;
        if(currSum+nums[n-1]>target) {
            return countPartitions(nums, n-1, target, currSum);
        }
        return countPartitions(nums, n-1, target, currSum) + countPartitions(nums, n-1, target, currSum+nums[n-1]);
    }
}
