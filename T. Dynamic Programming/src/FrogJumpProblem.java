import java.util.*;

//  Refer Striver's website
public class FrogJumpProblem {
    static int[] memo;
    public static void main(String[] args) {
        int[] heights = {10,20,30,10};
        memo = new int[heights.length];
        Arrays.fill(memo, -1);
        System.out.println(jumps(heights, heights.length-1));
        System.out.println(jumpsEff(heights, heights.length-1));
    }

    //  Time Complexity: O(2^n)
    //  Auxiliary Space: O(n)
    public static int jumps(int[] heights, int n) {
        if (n==0) {
            return 0;
        }
        int firstJump = jumps(heights, n-1) + Math.abs(heights[n]-heights[n-1]);
        int secondJump = Integer.MAX_VALUE;
        if (n>1) {
            secondJump = jumps(heights, n-2) + Math.abs(heights[n]-heights[n-2]);
        }
        return Math.min(firstJump, secondJump);
    }

    //  Time Complexity: O(n)
    //  Auxiliary Space: O(n)
    public static int jumpsEff(int[] heights, int n) {
        if (memo[n]==-1) {
            if (n==0) {
                return 0;
            }
            int firstJump = jumps(heights, n-1) + Math.abs(heights[n]-heights[n-1]);
            int secondJump = Integer.MAX_VALUE;
            if (n>1) {
                secondJump = jumps(heights, n-2) + Math.abs(heights[n]-heights[n-2]);
            }
            memo[n] = Math.min(firstJump, secondJump);
        }
        return memo[n];
    }
}
