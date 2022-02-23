public class CeilInASortedArray {
    //  Time Complexity : O(logn)
    //  Auxiliary Space : O(1)
    private static int findCeil(int[] arr, int n, int x) {
        int low = 0;
        int high = n-1;

        while(low<=high) {
            int mid = (low+high)/2;

            if (arr[mid]==x) {
                return mid;
            }
            else if (arr[mid]<x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
}
