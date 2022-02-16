import java.util.Deque;
import java.util.LinkedList;

public class DesignADataStructureWithMinMaxOperation {
    Deque<Integer> deque;

    public DesignADataStructureWithMinMaxOperation() {
        deque = new LinkedList<>();
    }

    public void insertMin(int x) {
        deque.offerFirst(x);
    }

    public void insertMax(int x) {
        deque.offerLast(x);
    }

    public int getMin() {
        return deque.peekFirst();
    }

    public int getMax() {
        return deque.peekLast();
    }

    public int extractMin() {
        return deque.pollFirst();
    }

    public int extractMax() {
        return deque.pollLast();
    }
}
