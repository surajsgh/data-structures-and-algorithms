// Rotate a matrix by 90 degree.
public class RotateAMatrix {
    public static int n = 4;
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        rotateByNaive(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
        rotateByEfficient(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

//    Anti-clockwise
//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void rotateByEfficient(int arr[][]) {
//        Transpose
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr[i].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

//        Reverse
        for (int i=0; i<arr.length; i++) {
            int low = 0;
            int high = arr.length - 1;
            while (low<high) {
                int temp = arr[low][i];
                arr[low][i] = arr[high][i];
                arr[high][i] = temp;
                low++;
                high--;
            }
        }
    }

    //  Clockwise
    public static void rotateClockwise(int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<(matrix[i].length/2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(n*n)
    public static void rotateByNaive(int arr[][]) {
        int temp[][] = new int[n][n];
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                temp[n-j-1][i] = arr[i][j];
            }
        }

        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}
