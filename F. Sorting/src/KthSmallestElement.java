// Find kth element in an array.

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 4, 5, 8, 11, 6, 26};
        int index = quickSelect(arr, 5);
        System.out.println(arr[index]);
        System.out.println(kthSmallestElement(arr, 5));
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(1)
    public static int kthSmallestElement(int arr[], int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }

    //  Time Complexity : O(nlogk)
    //  Auxiliary Space : O(k)
    public static int kthSmallest(int arr[], int n, int k)
    {
        // Your code here
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr) {
            queue.add(num);
            index++;
            if(index>k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

//    This algorithm is said to be more efficient as compared to the kthSmallestElement() method, even though the time complexity of quick select algo
//    is O(n*n). Bcoz in terms of avg case, quick select algorithm runs linearly.
//    This is quick select algorithm in order to findout kth smallest element.
//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static int quickSelect(int arr[], int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int p = partition(arr, left, right);
            if (p == k-1) {
                return p;
            }
            else if (p > k-1) {
                right = p-1;
            }
            else {
                left = p+1;
            }
        }
        return -1;
    }

//  Lomuto's method
    public static int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j=left; j<right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return (i+1);
    }
}
