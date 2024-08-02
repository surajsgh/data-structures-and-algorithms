public class ClimbingStairs {
    //  Time Complexity: O(n)
    //  Auxiliary Space: O(n)
    public static int climbStairsEff(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<=2 && i<=n; i++) {
            res[i] = i;
        }

        for(int i=3; i<=n; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairsEff(3));
    }
}
