import java.util.HashMap;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {
    //  Time Complexity : O(mnlogk)
    //  Auxiliary Space : O(mn)
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map.putIfAbsent(i-j, new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }

        return mat;
    }
}
