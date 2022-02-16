public class SearchInASortedRotatedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{10, 20, 30, 40, 60, 5, 8}, 5));
    }

//    Array contain distinct values.
//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int search(int arr[], int number) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid]==number) {
                return mid;
            }
            else if (arr[mid] >= arr[low]) {
                if (number >= arr[low] && number < arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (number > arr[mid] && number <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
