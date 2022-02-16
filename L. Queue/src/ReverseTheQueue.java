import java.util.*;
import java.util.Queue;

public class ReverseTheQueue {
    //  Iterative method
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    //  Recursively
    public static void reverseQueueRecursively(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int x = queue.peek();
        queue.remove();
        reverseQueueRecursively(queue);
        queue.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        reverseQueue(queue);
        for (Integer q : queue) {
            System.out.print(q + " ");
        }
        System.out.println();
        reverseQueueRecursively(queue);
        for (Integer q : queue) {
            System.out.print(q + " ");
        }
    }
}
