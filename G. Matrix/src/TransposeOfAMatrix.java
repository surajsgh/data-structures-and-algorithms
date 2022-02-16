public class TransposeOfAMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3},
                        {5, 6, 7},
                        {4, 8, 9}};
        transpose(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

//    This method is only applicable for the matrix with the same number of rows and columns.
//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void transpose(int arr[][]) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
