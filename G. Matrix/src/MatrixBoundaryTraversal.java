public class MatrixBoundaryTraversal {
    public static void main(String[] args) {
        int arr[][] = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        printBoundaryElements(arr);
        System.out.println();
        printEff(arr);
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void printBoundaryElements(int arr[][]) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (i == 0) {
                    System.out.print(arr[i][j] + " ");
                }
                else if (i == arr.length-1) {
                    System.out.print(arr[i][j] + " ");
                }
                else if (j == 0) {
                    System.out.print(arr[i][j] + " ");
                }
                else if (j == arr.length-1){
                    System.out.print(arr[i][j] + " ");
                }
                else {
                    System.out.print("");
                }
            }
        }
    }

    //  Time Complexity : O(m+n)
    public static void printEff(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        //  Print first row
        for (int i=0; i<col; i++) {
            System.out.print(arr[0][i] + " ");
        }

        for (int i=1; i<row; i++) {
            System.out.print(arr[i][col-1] + " ");
        }

        if (row > 1) {
            for (int i=col-2; i>=0; i--) {
                System.out.print(arr[row-1][i] + " ");
            }
        }

        if (col > 1) {
            for (int i=row-2; i>=1; i--) {
                System.out.print(arr[i][0] + " ");
            }
        }
    }
}
