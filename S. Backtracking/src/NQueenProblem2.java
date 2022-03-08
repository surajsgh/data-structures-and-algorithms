import java.util.ArrayList;

public class NQueenProblem2 {
    //  Time Complexity : O(n!)
    //  Auxiliary Space : O(n*n)
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] cols, nomralDiagonal, reversedDiagonal;

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        cols = new boolean[n];
        nomralDiagonal = new boolean[2*n];
        reversedDiagonal = new boolean[2*n];
        list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            temp.add(0);
        }
        print(list, 0, n, temp);
        return list;
    }

    static void print(ArrayList<ArrayList<Integer>> list, int row, int n, ArrayList<Integer> temp) {
        if(row==n) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int col=0; col<n; col++) {
            if(cols[col] || nomralDiagonal[row+col] || reversedDiagonal[row-col+n]) {
                continue;
            }
            cols[col] = true;
            nomralDiagonal[row+col] = true;
            reversedDiagonal[row-col+n] = true;
            temp.set(col, row+1);
            print(list, row+1, n, temp);
            cols[col] = false;
            nomralDiagonal[row+col] = false;
            reversedDiagonal[row-col+n] = false;
        }
    }
}
