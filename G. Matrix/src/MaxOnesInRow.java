public class MaxOnesInRow {
    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(1)
    int rowWithMax1s(int arr[][], int n, int m) {
        int row = 0;
        int col = m-1;
        int result = -1;
        while(row<n && col>=0) {
            if(arr[row][col]==1) {
                col--;
                result = row;
            }
            else {
                row++;
            }
        }
        return result;
    }
}
