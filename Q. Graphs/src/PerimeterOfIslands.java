public class PerimeterOfIslands {
    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(1)
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    islands++;  //  Count of islands
                    if(i<m-1 && grid[i+1][j]==1) neighbours++;   //  Count of down neighbours
                    if(j<n-1 && grid[i][j+1]==1) neighbours++;   //  Count of right neighbours
                }
            }
        }

        return 4*islands - 2*neighbours;
    }
}
