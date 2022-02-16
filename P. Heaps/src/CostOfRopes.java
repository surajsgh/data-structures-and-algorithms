import java.util.Queue;

public class CostOfRopes {
    //  Time Complexity : O(nlogn)
    //  Auxiliary Space : O(n)
    long minCost(long arr[], int n)
    {
        // your code here
        long sum = 0;
        long result = 0;

        Queue<Long> queue = (Queue<Long>) new PriorityQueue<Long>();
        for(int i=0; i<n; i++) {
            queue.add(arr[i]);
        }

        while(queue.size()>1) {
            sum = queue.poll() + queue.poll();
            result += sum;
            queue.add(sum);
        }

        return result;
    }
}
