import java.util.ArrayList;
import java.util.Queue;

public class KthLargestElementInAStream {
    //  Time Complexity : O(nlogk)
    //  Auxiliary Space : O(k)
    public void kthLargest(int arr[], int n, int k){
        // Your code here
        Queue<Integer> queue = (Queue<Integer>) new PriorityQueue<Integer>();

        for(int num : arr) {
            if(queue.size()<k) {
                queue.add(num);
            }
            else {
                if(num>queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
            if(queue.size()>=k) {
                System.out.print(queue.peek() + " ");
            }
            else {
                System.out.print(-1 + " ");
            }
        }
    }
}

//  LEETCODE VERSION
/*
class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<Integer>();
        for(int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(queue.size() < k) {
            queue.add(val);
        }
        else if(queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
*/