import java.util.Deque;
import java.util.LinkedList;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(10);
        deque.offerFirst(20);
        deque.offerLast(30);

        for (int num : deque) {
            System.out.println(num);
        }

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}
