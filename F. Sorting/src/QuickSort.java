// This quick sort is implemented using the lomuto partition. 

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{8,4,7,9,3,10,5};
        quickSort(arr, 0, arr.length-1);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

//    Best Time Complexity : O(nlog(n))
//    Average Time Complexity : O(nlog(n))
//    Worst Time Complexity : O(n*n) 
//    Auxiliary Space : O(logn)
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = quickPartition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }

    public static int quickPartition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j=low; j<=high-1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }
}
