import java.sql.Time;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortKSortedArray {
    //  Time Complexity : O((n+k)log(k))
    //  Auxiliary Space : O(k)
    public static void sortKSortedArray(int[] arr, int n, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i=0; i<k; i++) {
            queue.add(arr[i]);
        }

        int index = 0;
        for (int i=k+1; i<n; i++) {
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()) {
            arr[index++] = queue.poll();
        }
    }
}
