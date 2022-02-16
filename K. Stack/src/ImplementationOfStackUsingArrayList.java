import java.util.ArrayList;

class Stack1 {
    ArrayList<Integer> list = new ArrayList<>();

    void push(int x) {
        list.add(x);
    }

    void pop() {
        list.remove(list.size()-1);
    }

    int peek() {
        return list.get(list.size()-1);
    }

    int size() {
        return list.size();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}

public class ImplementationOfStackUsingArrayList {
    public static void main(String[] args) {
        Stack1 stack = new Stack1();
        stack.push(2);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
