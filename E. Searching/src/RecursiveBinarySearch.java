public class RecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[]{10, 20, 30, 40, 50}, 0, 4, 10));
    }

//     Time Complexity : O(log(n))
//     Auxiliary Space : O(log(n))
    public static int recursiveBinarySearch(int arr[], int low, int high, int number) {
        if (low>high) {
            return -1;
        }
        int mid = (low + high)/2;
        if (arr[mid]==number) {
            return mid;
        }
        else if (arr[mid] > number) {
            return recursiveBinarySearch(arr, low, mid-1, number);
        }
        else {
            return recursiveBinarySearch(arr, mid+1, high, number);
        }
    }
}
