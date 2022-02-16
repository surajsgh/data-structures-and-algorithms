//  In SpiralMatrix1 we were supposed to just print the matrix in the spiral order while in SpiralMatrix2 we're supposed to generate the
//  spiral matrix.
public class SpiralMatrix2 {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int num = 1;
        int row = arr.length;
        int column = arr[0].length;

        int top = 0;
        int left = 0;
        int bottom = row - 1;
        int right = column - 1;

        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                arr[top][i] = num++;
            }
            top++;

            for(int j=top; j<=bottom; j++) {
                arr[j][right] = num++;
            }
            right--;

            if(top<=bottom) {
                for(int k=right; k>=left; k--) {
                    arr[bottom][k] = num++;
                }
                bottom--;
            }

            if(left<=right) {
                for(int l=bottom; l>=top; l--) {
                    arr[l][left] = num++;
                }
                left++;
            }
        }
        return arr;
    }
}
