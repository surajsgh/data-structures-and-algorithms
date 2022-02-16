public class IndexOfFirstOccurenceInAnArray {
    public static void main(String[] args) {
        System.out.println(firstOccurence(new int[]{10, 10, 10, 20, 20}, 10));
    }

//    Using binary search approach
//    Time Complexity : O(log(n))
//    Space Complexity : O(1);
    public static int firstOccurence(int arr[], int x) {
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
                if (mid==0 || (arr[mid] != arr[mid-1])) {
                    return mid;
                }
                else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }
}
