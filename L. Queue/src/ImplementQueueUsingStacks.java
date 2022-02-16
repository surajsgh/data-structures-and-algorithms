import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public ImplementQueueUsingStacks() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int x) {
        while(!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }

        secondStack.push(x);

        while(!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
    }

    public int pop() {
        if(firstStack.isEmpty()) return -1;
        return firstStack.pop();
    }

    public int peek() {
        if(firstStack.isEmpty()) return -1;
        return firstStack.peek();
    }

    public boolean empty() {
        return firstStack.isEmpty();
    }

}
