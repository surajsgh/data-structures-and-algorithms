public class SolveSudokuProblem {
    //  Time Complexity : O(9^(N*N))
    //  Auxiliary Space : O(N*N)
    static boolean solve(int grid[][], int N) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(grid[i][j]==0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty) {
                break;
            }
        }

        if(isEmpty) {
            return true;
        }

        for(int n=1; n<=N; n++) {
            if(isSafe(grid, N, row, col, n)) {
                grid[row][col] = n;
                if(solve(grid, N)) return true;
                grid[row][col] = 0;
            }
        }

        return false;
    }
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int N = grid.length;
        return solve(grid, N);
    }

    static boolean isSafe(int[][] grid, int N, int i, int j, int n) {
        for(int k=0; k<grid.length; k++) {
            if(grid[i][k]==n || grid[k][j]==n) return false;
        }

        int sqrt = (int)Math.sqrt(N);
        int boxRowStart = i-i%sqrt;
        int boxColStart = j-j%sqrt;

        for(int a=boxRowStart; a<sqrt+boxRowStart; a++) {
            for(int b=boxColStart; b<sqrt+boxColStart; b++) {
                if(grid[a][b]==n) {
                    return false;
                }
            }
        }

        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        int N = grid.length;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            // System.out.println();
            // if ((i + 1) % (int)Math.sqrt(N) == 0)
            // {
            //     System.out.print("");
            // }
        }
    }
}
