//  https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
//  https://www.geeksforgeeks.org/shortest-common-supersequence/
//  https://www.geeksforgeeks.org/longest-repeating-subsequence/
//  https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

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
        System.out.println(findLongestCommonSubsequenceEff2(first, second, first.length(), second.length()));
    }

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(mn)
    public static int findLongestCommonSubsequenceEff2(String first, String second, int m, int n) {
        int[][] matrix = new int[m+1][n+1];
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                matrix[i][j] = -1;
            }
        }

        for (int i=0; i<=m; i++) {
            matrix[i][0] = 0;
        }

        for (int i=0; i<=n; i++) {
            matrix[0][i] = 0;
        }

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (first.charAt(i-1)==second.charAt(j-1)) {
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[m][n];
    }

    //  MEMOIZATION
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
