import java.util.Stack;
import java.util.Queue;

public class ReverseFirstKElements {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        int n = q.size();
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++) {
            stack.push(q.poll());
        }

        int num = stack.peek();

        while(!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        for(int i=0; i<n-k; i++) {
            q.offer(q.poll());
        }

        return q;
    }
}
