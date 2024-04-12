public class KnapSackProblem {
    public static void main(String[] args) {
        int[] arr = {10, 40, 30, 50};
        int[] weights = {5, 4, 6, 3};
        int weight = 10;
        int n = 4;
        System.out.println(knapSackProblem(weights, arr, weight, n));
        System.out.println(knapSackProblemDP(weights, arr, weight, n));
    }

    //  Time Complexity: O(w*n)
    //  Auxiliary Space: O(w*n)
    public static int knapSackProblemDP(int[] weights, int[] values, int weight, int n) {
        int[][] matrix = new int[n+1][weight+1];

        for (int i=0; i<=weight; i++) {
            matrix[0][i] = 0;
        }

        for(int i=0; i<=n; i++) {
            matrix[i][0] = 0;
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<weight+1; j++) {
                if(weights[i-1]>j) {
                    matrix[i][j] = matrix[i-1][j];
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j-weights[i-1]] + values[i-1]);
                }
            }
        }

        return matrix[n][weight];
    }

    //  Time Complexity: O(2**N)
    //  Auxiliary Space: O(2**N)
    public static int knapSackProblem(int[] weights, int[] values, int weight, int n) {
        if (n==0 || weight==0) return 0;
        if (weights[n-1]>weight) {
            return knapSackProblem(weights, values, weight, n-1);
        }
        else {
            return Math.max(knapSackProblem(weights, values, weight, n-1), (knapSackProblem(weights, values, weight-weights[n-1], n-1) + values[n-1]));
        }
    }
}
