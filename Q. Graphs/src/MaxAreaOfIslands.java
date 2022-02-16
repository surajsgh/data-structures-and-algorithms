public class MaxAreaOfIslands {
    int m;
    int n;

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(l)
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int result = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] > 0) result = Math.max(result, helper(grid, i, j));
            }
        }

        return result;
    }

    public int helper(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) return 0;
        grid[i][j] = 0;
        return 1 + helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j-1) + helper(grid, i, j+1);
    }
}
