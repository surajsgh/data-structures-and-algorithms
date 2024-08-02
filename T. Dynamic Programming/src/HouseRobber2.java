import java.lang.reflect.Array;
import java.util.Arrays;

public class HouseRobber2 {
    static int[] memo;
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        memo = new int[n];
        Arrays.fill(memo, -1);

        int index1 = 0;
        int index2 = 0;

        for(int i=0; i<n; i++) {
            if(i!=n-1) temp2[index2++] = nums[i];
            if(i!=0) temp1[index1++] = nums[i];
        }

        int first = robUtil(temp1, temp1.length);

        Arrays.fill(memo, -1);
        int second =  robUtil(temp2, temp2.length);
        return Math.max(first, second);
    }

    public static int robUtil(int[] nums, int n) {
        System.out.println(Arrays.toString(nums) + " " + n + " " + memo[n]);
        if(memo[n]==-1) {
            if(n==1) {
                return nums[0];
            }
            else if(n==2) {
                return Math.max(nums[0], nums[1]);
            }
            else {
                memo[n] = Math.max(robUtil(nums, n-1), robUtil(nums, n-2)+nums[n-1]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
