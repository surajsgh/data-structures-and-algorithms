// This program is also known as Dutch National Flag Algorithm.
public class SortAnArrayWithThreeTypesOfElements {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 2, 2, 1, 2, 1, 0};
        sort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static void sort(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
