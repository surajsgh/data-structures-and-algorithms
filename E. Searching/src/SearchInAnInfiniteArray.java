public class SearchInAnInfiniteArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 10, 15, 20, 40, 60, 80, 100, 200, 500, 1000};
        System.out.println(search(arr, 100));
    }

//     Unbounded binary search algorithm
//    Time Complexity : O(log(pos))
//    Auxiliary Space : O(1)
    public static int searchEfficient(int arr[], int number) {
        if (arr[0]==number) {
            return 0;
        }
        int i=1;
        while (arr[i]<number) {
            i = 2 * i;
        }
        if (arr[i]==number) {
            return i;
        }
        return binarySearch(arr, i/2 + 1, i-1, 100);
    }

    public static int binarySearch(int arr[], int low, int high, int number) {
        while (low < high) {
            int mid = (low + high)/2;
            if (arr[mid]==number) {
                return mid;
            }
            else if (arr[mid] > number) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
    public static int search(int arr[], int number) {
        int i=0;
        while (true) {
            if (arr[i] == number) {
                return i;
            }
            if (arr[i] > number) {
                return -1;
            }
            i++;
        }
    }
}
