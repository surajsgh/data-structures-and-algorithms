import java.util.Arrays;

public class MaximumSumWithNoTwoConsecutive {
    static int[] memo;
    public static void main(String[] args) {
        int[] nums = {10, 15, 5, 20};
        System.out.println(maximumTwoSumWithNoTwoConsecutive(nums, nums.length));
        memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        System.out.println(maximumTwoSumWithNoTwoConsecutiveDP(nums, nums.length));
    }

    //  Time Complexity: O(2**n)
    //  Auxiliary Space: O(2**n)
    public static int maximumTwoSumWithNoTwoConsecutive(int[] arr, int n) {
        if(n==1) {
            return arr[0];
        }
        else if(n==2) {
            return Math.max(arr[0], arr[1]);
        }
        else {
            return Math.max(maximumTwoSumWithNoTwoConsecutive(arr, n-1), maximumTwoSumWithNoTwoConsecutive(arr, n-2) + arr[n-1]);
        }
    }

    //  Time Complexity: O(n)
    //  Auxiliary Space: O(n)
    public static int maximumTwoSumWithNoTwoConsecutiveDP(int[] arr, int n) {
        if(memo[n]==-1) {
            if(n==1) {
                return arr[0];
            }
            else if (n==2) {
                return Math.max(arr[0], arr[1]);
            }
            else {
                memo[n] = Math.max(maximumTwoSumWithNoTwoConsecutiveDP(arr, n-1), maximumTwoSumWithNoTwoConsecutiveDP(arr, n-2) + arr[n-1]);
            }
        }
        return memo[n];
    }
}
