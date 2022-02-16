class Stack {
    int[] arr;
    int cap;
    int top;

    Stack(int c) {
        top = -1;
        cap = c;
        arr = new int[cap];
    }

    void push(int x) {
        if (top==cap-1) {
            System.out.println("Stack is full.");
            return;
        }
        top++;
        arr[top] = x;
    }

    int pop() {
        if (top==-1) {
            System.out.println("Stack is empty.");
        }
        int res = arr[top];
        top--;
        return res;
    }

    int peek() {
        if (top==-1) {
            System.out.println("Stack is empty.");
        }
        return arr[top];
    }

    int size() {
        return top+1;
    }

    boolean isEmpty() {
        return top==-1;
    }
}

public class ImplementationOfStackUsingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}