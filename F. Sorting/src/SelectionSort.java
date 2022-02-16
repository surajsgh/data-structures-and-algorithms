import java.util.Arrays;

// In selection sort algorithm, the minimum element is found out first and then it gets replaced with the initial element of the array.
public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {3, 12, 4, 1, 5, 6};
        System.out.println(Arrays.toString(arr));
        selectSortEfficient(arr);
        System.out.println(Arrays.toString(arr));
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(n)
    public static void selectionSortNaive(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        for (int i=0; i<n; i++) {
            int minInd = 0;
            for (int j=1; j<n; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            temp[i] = arr[minInd];
            arr[minInd] = Integer.MAX_VALUE;
        }

//        Copy every elements from temp array to the original array.
        for (int i=0; i<arr.length; i++) {
            arr[i] = temp[i];
        }
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void selectSortEfficient(int arr[]) {
        int temp = 0;
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            int minInd = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }
}
