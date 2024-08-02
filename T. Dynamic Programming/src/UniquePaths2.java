import java.util.*;

public class UniquePaths2 {
    //  Time Complexity: O(row*col)
    //  Auxiliary Space: O(row*col)
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        memo = new int[row][col];

        for(int[] arr: memo) {
            Arrays.fill(arr, -1);
        }

        return util(obstacleGrid, row-1, col-1);
    }

    public int util(int[][] obstacleGrid, int row, int col) {
        if(row>=0 && col>=0 && obstacleGrid[row][col]==1) return 0;
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;
        if(memo[row][col]!=-1) return memo[row][col];

        int left = util(obstacleGrid, row, col-1);
        int up = util(obstacleGrid, row-1, col);

        return memo[row][col] = left+up;
    }
}
