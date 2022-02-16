// The array is virtually split into a sorted and an unsorted array. Element from the unsorted array is picked up and then gets placed onto the right position in sorted part. 
public class InsertionSort {
//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void insertionSort(int arr[]) {
        for (int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
