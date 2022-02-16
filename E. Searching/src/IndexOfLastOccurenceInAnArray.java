public class IndexOfLastOccurenceInAnArray {
    public static void main(String[] args) {
        System.out.println(lastOccurence(new int[]{5, 10, 10, 10, 10, 20, 20}, 20));
    }

//    Binary Search algorithm
//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int lastOccurence(int arr[], int x) {
        int initial = 0;
        int last = arr.length-1;
        while (initial <= last) {
            int mid = (initial+last)/2;
            if (arr[mid] > x) {
                last = mid - 1;
            }
            else if (arr[mid] < x) {
                initial = mid + 1;
            }
            else {
                if (mid==arr.length-1 || (arr[mid] != arr[mid+1])) {
                    return mid;
                }
                else {
                    initial = mid + 1;
                }
            }
        }
        return -1;
    }
}
