public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{10, 20, 30, 40, 50}, 90));
    }

//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int binarySearch(int arr[], int x) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (arr[mid] == x) {
                return mid;
            }
            else if (arr[mid] > x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
