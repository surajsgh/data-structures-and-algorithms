import java.util.*;

public class UniquePaths {
    int[][] memo;

    //  Time Complexity: O(mn)
    //  Auxiliary Space: O(mn)
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return util(m-1, n-1);
    }

    public int util(int m, int n) {
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        int up = util(m-1, n);
        int left = util(m, n-1);
        return memo[m][n] = up+left;
    }
}
