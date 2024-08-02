public class UniquePaths2 {
    //  Time Complexity: O(2^(row*col))
    //  Auxiliary Space: O(row*col)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        return util(obstacleGrid, row-1, col-1);
    }

    public int util(int[][] obstacleGrid, int row, int col) {
        if(row>=0 && col>=0 && obstacleGrid[row][col]==1) return 0;
        if(row==0 && col==0) return 1;
        if(row<0 || col<0) return 0;

        int left = util(obstacleGrid, row, col-1);
        int up = util(obstacleGrid, row-1, col);

        return left+up;
    }
}
