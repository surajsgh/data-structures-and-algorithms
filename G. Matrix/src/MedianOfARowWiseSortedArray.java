import java.util.Arrays;

public class MedianOfARowWiseSortedArray {

//    Time Complexity : O(rows*log(columns)*log(max-min))
//    Auxiliary Space : O(1)
    public static int findMedian(int arr[][]) {
        int rows = arr.length;
        int columns = arr[0].length;
        int min = arr[0][0];
        int max = arr[0][columns-1];
        for (int i=1; i<rows; i++) {
            if (arr[i][0] < min) {
                min = arr[i][0];
            }

            if (arr[i][columns-1] > max) {
                max = arr[i][columns-1];
            }
        }
        int medianPosition = (rows*columns + 1)/2;

//        Binary Search
        while (min < max) {
            int mid = (max + min)/2;
            int midPos = 0;
            for (int i=0; i<rows; i++) {
                int pos = Arrays.binarySearch(arr[i], mid) + 1;
                midPos += Math.abs(pos);
            }

            if (midPos < medianPosition) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        return min;
    }
}
