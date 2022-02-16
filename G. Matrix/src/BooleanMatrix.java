import java.util.HashSet;
import java.util.Set;

public class BooleanMatrix {
    //  Time Complexity : O(m*n)
    //  Auxiliary Space : O(m+n)
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int R = matrix.length;
        int C = matrix[0].length;
        for (int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(matrix[i][j]==0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
