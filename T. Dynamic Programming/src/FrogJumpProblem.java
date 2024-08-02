//  Refer Striver's website
public class FrogJumpProblem {
    public static void main(String[] args) {
        int[] heights = {10,20,30,10};
        System.out.println(jumps(heights, heights.length-1));
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
}
