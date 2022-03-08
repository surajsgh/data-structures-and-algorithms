public class NQueenProblem {
    private static final int SIZE = 4;
    public static void main(String[] args) {
        int board[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 } };
        solve(board);
    }

    private static boolean solve(int[][] board) {
        if (!solveRec(board,0)) {
            System.out.println("Solution not possible...");
            return false;
        }

        print(board);
        return true;
    }

    private static void print(int[][] board) {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean check(int[][] board, int row, int column) {
        int i;
        int j;
        for (i=0; i<column; i++) {
            if (board[row][i]==1) return false;
        }

        for (i=row, j=column; i>=0 && j>=0; i--, j--) {
            if (board[i][j]==1) return false;
        }

        for (i=row, j=column; i<SIZE && j>=0; i++, j--) {
            if (board[i][j]==1) return false;
        }

        return true;
    }

    private static boolean solveRec(int[][] board, int column) {
        if (column==SIZE) {
            return true;
        }

        for (int i=0; i<SIZE; i++) {
            if (check(board, i, column)) {
                board[i][column] = 1;

                if (solveRec(board, column+1)) return true;

                board[i][column] = 0;
            }
        }

        return false;
    }
}
