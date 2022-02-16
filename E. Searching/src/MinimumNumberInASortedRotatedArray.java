public class MinimumNumberInASortedRotatedArray {
//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    static long minNumber(int arr[], long low, long high)
    {
        if(arr.length == 1) {
            return arr[0];
        }
        if(arr[(int)low] < arr[(int)high]) {
            return arr[(int)low];
        }
        while(low <= high) {
            int mid = (int)(low + high)/2;
            if(arr[mid] > arr[mid+1]) {
                return arr[mid + 1];
            }
            if(arr[mid] < arr[mid-1]) {
                return arr[mid];
            }
            if(arr[mid] > arr[0]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
