public class UniqueBSTs {
    public static void main(String[] args) {
        System.out.println(uniqueBSTs(4));
    }

    //  Time Complexity: O()
    public static int uniqueBSTs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i=1; i<=n; i++) {
            dp[i] = 0;
            for (int j=0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
}
