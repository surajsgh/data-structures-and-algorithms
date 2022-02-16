import java.sql.Time;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyMaximumItemWithGivenSum {
    //  Time Complexity : O(nlogn)
    //  Auxiliary Space : O(1)
    public static int result(int[] arr, int n, int sum) {
        int res=0;
        Arrays.sort(arr);
        for (int i=0; i<n; i++) {
            if (arr[i]<=sum) {
                sum -= arr[i];
                res++;
            }
            else {
                break;
            }
        }
        return res;
    }

    //  Time Complexity : O((res)logn) Avg Case / O(nlogn) Worst Case
    //  Auxiliary Space : O(n)
    public static int resultEfficient(int[] arr, int n, int sum) {
        int res = 0;
        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i=0; i<n; i++) {
            queue.add(arr[i]);
        }

        for (int i=0; i<n; i++) {
            if (queue.peek()<=sum) {
                sum -= queue.poll();
                res++;
            }
            else {
                break;
            }
        }
        return res;
    }
}
