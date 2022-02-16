// Implementation of merge function to be used in merge sorting algorithm.

public class MergeSortWithThreeVars {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 20, 40, 15, 30};
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        merge(arr, 0, 2, 4);
        for (int j=0; j<arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(n)
    public static void mergeSort(int arr[], int low, int right) {
        if (right > low) {
            int m = (low + right)/2;
            mergeSort(arr, low, m);
            mergeSort(arr, m+1, right);
            merge(arr, low, m, right);
        }
    }

//     Time Complexity : O(n)
//     Auxiliary Space : O(n)
    public static void merge(int arr[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for (int i=0; i<left.length; i++) {
            left[i] = arr[low + i];
        }
        for (int j=0; j<right.length; j++) {
            right[j] = arr[n1 + j];
        }
        int i=0;
        int j=0;
        int k=0;
        while (i<n1 && j<n2) {
            if (left[i]<=right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            }
            else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        while (i<n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j<n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
