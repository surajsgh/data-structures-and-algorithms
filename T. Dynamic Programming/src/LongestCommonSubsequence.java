import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int[][] memo;

    public static void main(String[] args) {
        String first = "AXYZ";
        String second = "BAZ";
        memo = new int[first.length()+1][second.length()+1];
        for (int[] num : memo) {
            Arrays.fill(num, -1);
        }
        System.out.println(findLongestCommonSubsequence("AXYZ", "BAZ", 4, 3));
        System.out.println(findLongestCommonSubsequenceEff(first, second, first.length(), second.length()));
    }

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(mn)
    public static int findLongestCommonSubsequenceEff(String first, String second, int m, int n) {
        if (memo[m][n]!=-1) {
            return memo[m][n];
        }
        if (m==0 || n==0) {
            memo[m][n] = 0;
        }
        if (first.charAt(m-1)==second.charAt(n-1)) {
            memo[m][n] = 1 + findLongestCommonSubsequence(first, second, m-1, n-1);
        }
        else {
            memo[m][n] = Math.max(findLongestCommonSubsequence(first, second, m-1, n), findLongestCommonSubsequenceEff(first, second, m, n-1));
        }
        return memo[m][n];
    }

    //  Time Complexity : O(2^(m))
    public static int findLongestCommonSubsequence(String first, String second, int m, int n) {
        if (m==0 || n==0) {
            return 0;
        }
        if (first.charAt(m-1)==second.charAt(n-1)) {
            return 1 + findLongestCommonSubsequence(first, second, m-1, n-1);
        }
        return Math.max(findLongestCommonSubsequence(first, second, m-1, n), findLongestCommonSubsequence(first, second, m, n-1));
    }
}
