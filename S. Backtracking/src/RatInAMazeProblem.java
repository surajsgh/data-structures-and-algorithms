public class RatInAMazeProblem {
    private static final int SIZE = 4;
    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        int N = maze.length;
        solveMaze(maze);
    }

    //  Time Complexity : O(2^(m*n))
    //  Auxiliary Space : O(m*n)
    private static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[SIZE][SIZE];

        if (!solveMazeRec(maze, 0, 0, solution)) {
            System.out.println("Solution doesn't exist.");
            return false;
        }

        printSolution(solution);
        return true;
    }

    private static boolean solveMazeRec(int[][] maze, int i, int j, int[][] solution) {
        if (i==SIZE-1 && j==SIZE-1 && maze[i][j]==1) {
            solution[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j)) {
            solution[i][j] = 1;
            if (solveMazeRec(maze, i+1, j, solution)) {
                return true;
            }

            if (solveMazeRec(maze, i, j+1, solution)) {
                return true;
            }

            solution[i][j] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int i, int j) {
        return (i<SIZE && j<SIZE && maze[i][j]==1);
    }

    private static void printSolution(int[][] solution) {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
