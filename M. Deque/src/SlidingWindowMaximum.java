import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public int[] maxSlidingWindowNaive(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int index = 0;

        for(int i=0; i<n-k+1; i++) {
            int max = nums[i];
            for(int j=i+1; j<i+k; j++) {
                max = Math.max(nums[j], max);
            }
            res[index++] = max;
        }

        return res;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        int[] res = new int[n-k+1];

        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<k; i++) {
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        for(int i=k; i<n; i++) {
            res[index++] = nums[deque.peekFirst()];

            while(!deque.isEmpty() && deque.peekFirst()<=i-k) {
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        res[index] = nums[deque.peekFirst()];
        return res;
    }
}
