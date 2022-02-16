import java.util.Stack;

//  Time Complexity : O(1)
//  Auxiliary Space : O(1)
class MyStack {
    Stack<Integer> stack;
    int min;

    MyStack() {
        stack = new Stack<>();
    }

    void push(int x) {
        if (stack.isEmpty()) {
            min = x;
            stack.add(x);
        }
        else if (x<=min) {
            stack.add(2*x-min);
            min = x;
        }
        else {
            stack.add(x);
        }
    }

    int pop() {
       int t = stack.peek();
       stack.pop();
       if (t<=min) {
           int res = min;
           min = 2*min-t;
           return res;
       }
       else {
           return t;
       }
    }

    int peek() {
        int t = stack.peek();
        return ((t<=min)?min:t);
    }

    int getMin() {
        return min;
    }
}

/*
class MinStack {
    Node head;

    // public MinStack() {
    //     head = null;
    // }

    public void push(int val) {
        if(head==null) {
            head = new Node(val, val);
        }
        else {
            Node node = new Node(val, Math.min(val, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if(head!=null) {
            head = head.next;
        }
    }

    public int top() {
        if(head!=null) {
            return head.data;
        }
        return -1;
    }

    public int getMin() {
        if(head!=null) {
            return head.min;
        }
        return -1;
    }
}

class Node {
    Node next;
    int data;
    int min;

    Node(int x, int minimum) {
        data = x;
        next = null;
        min = minimum;
    }
}
* */

public class DesignAStackWithGetMin {
    public static void main(String[] args) {
        MyStack stack=new MyStack();;
        stack.push(4);
        stack.push(5);
        stack.push(8);
        stack.push(1);
        stack.pop();
        System.out.print(" Minimum Element from Stack: " + stack.getMin() );
    }
}
