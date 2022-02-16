import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargestKElements {
    //  Time Complexity : O(k+(n-k)log(k))
    //  Auxiliary Space : O(k)
    public static void print(int[] arr, int n, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i=0; i<k; i++) {
            queue.add(arr[i]);
        }

        for (int i=k; i<n; i++) {
            if (queue.peek()>=arr[i]) {
                continue;
            }
            else {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}
