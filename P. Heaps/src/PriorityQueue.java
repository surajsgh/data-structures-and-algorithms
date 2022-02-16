import java.util.Collections;
import java.util.Queue;

public class PriorityQueue<I extends Number> {
    public static void main(String[] args) {
        //  Default MinHeap
        Queue<Integer> queue = new java.util.PriorityQueue<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(15);
        System.out.println(queue.peek());   // 10
        System.out.println(queue.poll());   // 10
        System.out.println(queue.peek());   // 15

        //  MaxHeap
        Queue<Integer> secondQueue = new java.util.PriorityQueue<Integer>(Collections.reverseOrder());
        secondQueue.add(10);
        secondQueue.add(20);
        secondQueue.add(15);
        System.out.println(secondQueue.peek()); //  20
        System.out.println(secondQueue.poll()); //  20
        System.out.println(secondQueue.peek()); //  15
    }
}
