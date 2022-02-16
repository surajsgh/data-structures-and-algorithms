// A peak element is an element which is greater than both of its neighbours.
public class FindAPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakNaive(new int[]{10, 7, 8, 20, 12}));
        System.out.println(findPeakElementEfficient(new int[]{10, 7, 8, 20, 12}));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int findPeakNaive(int arr[]) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] >= arr[1]) {
            return arr[0];
        }
        if (arr[arr.length-1] >= arr[arr.length-2]) {
            return arr[arr.length-1];
        }
        int i = 1;
        while (i<arr.length-1) {
            if ((arr[i] >= arr[i-1]) && (arr[i] >= arr[i+1])) {
                return arr[i];
            }
            i++;
        }
        return -1;
    }

//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int findPeakElementEfficient(int arr[]) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (high + low)/2;
            if ((mid==0 || arr[mid] >= arr[mid-1]) && (mid==arr.length-1 || arr[mid] >= arr[mid+1])) {
                return arr[mid];
            }
            else if ((arr[mid] <= arr[mid-1])) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
