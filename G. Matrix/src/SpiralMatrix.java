public class SpiralMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        printSpiralMatrix(arr, 4, 4);
    }

//    Time Complexity : O(R*C)
//    Auxiliary Space : O(1)
    public static void printSpiralMatrix(int arr[][], int column, int row) {
        int top=0, left=0, bottom=row-1, right=column-1;
        while (top<=bottom &&  left<=right) {
//            Top Row
            for (int i=left; i<=right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

//            Right Column
            for (int j=top; j<=bottom; j++) {
                System.out.print(arr[j][right] + " ");
            }
            right--;

//            Bottom Row
            if (top<=bottom) {
                for (int k=right; k>=left; k--) {
                    System.out.print(arr[bottom][k] + " ");
                }
                bottom--;
            }
//            Left Column
            if (left<=right) {
                for (int l=bottom; l>=top; l--) {
                    System.out.print(arr[l][left] + " ");
                }
                left++;
            }
        }
    }
}
