import java.util.*;

public class MinPathSum {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        memo = new int[row][col];
        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return util(grid, row-1, col-1);
    }

    public int util(int[][] grid, int row, int col) {
        if(row==0 && col==0) return grid[row][col];
        if(row<0 || col<0) return 100000;
        if(memo[row][col]!=-1) return memo[row][col];

        int left = grid[row][col] + util(grid, row, col-1);
        int up = grid[row][col] + util(grid, row-1, col);

        return memo[row][col] = Math.min(left, up);
    }
}
