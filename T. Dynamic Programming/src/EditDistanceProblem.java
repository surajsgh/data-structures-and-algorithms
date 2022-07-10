public class EditDistanceProblem {
    public static void main(String[] args) {
        System.out.println(editDistanceNaive("CAT", "CUT", 3, 3));
        System.out.println(editDistance("CAT", "CUT", 3, 3));
    }

    //  Time Complexity : O(3^m)
    public static int editDistanceNaive(String first, String second, int m, int n) {
        if (m==0) return n;
        if (n==0) return m;
        if (first.charAt(m-1)==second.charAt(n-1)) {
            return editDistanceNaive(first, second, m-1, n-1);
        }
        return 1 + Math.min(editDistanceNaive(first, second, m-1, n), Math.min(editDistanceNaive(first, second, m, n-1), editDistanceNaive(first, second, m-1, n-1)));
    }

    //  Time Complexity : O(mn)
    //  Auxiliary Space : O(mn)
    public static int editDistance(String first, String second, int m, int n) {
        int[][] matrix = new int[m+1][n+1];

        for (int i=0; i<m+1; i++) {
            matrix[i][0] = i;
        }

        for (int i=0; i<n+1; i++) {
            matrix[0][i] = i;
        }

        for (int i=1; i<m+1; i++) {
            for (int j=1; j<n+1; j++) {
                if (first.charAt(i-1)==second.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                }
            }
        }

        return matrix[m-1][n-1];
    }
}
