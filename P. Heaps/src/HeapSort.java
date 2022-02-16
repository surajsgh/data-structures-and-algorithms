public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort heap = new HeapSort();
        heap.heapSort(arr, arr.length);
        for (int i =0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //  Heap Sort
    //  Step 1 : Build a max heap
    public void maxHeapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left<n && arr[left]>arr[largest]) {
            largest = left;
        }

        if (right<n && arr[right]>arr[largest]) {
            largest = right;
        }

        if (largest!=i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }

    public void buildHeapForSorting(int[] arr, int n) {
        for (int i=n/2-1; i>=0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    //  Step 2 : Repeatedly swap root with last node, reduce heap size by one and heapify.
    //  Time Complexity : O(nlogn)
    public void heapSort(int[] arr, int n) {
        buildHeapForSorting(arr, n);
        for (int i=n-1; i>=0; i--) {
            int temp  = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, 0, i);
        }
    }
}
