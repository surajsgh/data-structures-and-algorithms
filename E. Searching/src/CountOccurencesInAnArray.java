public class CountOccurencesInAnArray {
    public static void main(String[] args) {
        int arr[] = new int[]{20, 20, 20, 20, 20, 20};
        System.out.println(countOcc(arr, 20));
    }

//    Using Binary Search Algorithm
//    Time Complexity : O(log(n))
//    Auxiliary Space : O(1)
    public static int countOcc(int arr[], int x) {
        int first = firstOcc(arr, 20);
        if (first == -1) {
            return 0;
        }
        else {
            return (lastOccurence(arr, x) - first + 1);
        }
    }

    public static int firstOcc(int arr[], int x) {
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
