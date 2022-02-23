import java.sql.Time;

public class FloorInASortedArray {
//    Time Comlexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int floorSearch(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;

        if(x >= arr[high]) {
            return high;
        }

        while(low <= high) {
            int mid = (low+high)/2;

            if (arr[mid] == x) {
                return mid;
            }

            if (mid>=0 && arr[mid-1]<=x && x<arr[mid]) {
                return mid-1;
            }

            else if (x < arr[mid]) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
