import java.util.*;
import java.util.Queue;

public class ImplementStackUsingQueue {
    static class Stack {
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        static int currentSize;

        Stack() {
            currentSize = 0;
        }

        static int top() {
            if (queue1.isEmpty()) {
                return -1;
            }
            return queue1.peek();
        }

        static int size() {
            return currentSize;
        }

        static void pop() {
            if (queue1.isEmpty()) {
                return;
            }
            queue1.remove();
            currentSize--;
        }

        static void push(int x) {
            currentSize++;
            queue2.add(x);

            while (!queue1.isEmpty()) {
                queue2.add(queue1.peek());
                queue1.remove();
            }

            Queue<Integer> queue = queue1;
            queue1 = queue2;
            queue2 = queue;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.size());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.size());
    }
}
