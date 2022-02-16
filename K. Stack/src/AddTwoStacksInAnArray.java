class TwoStacks {
    int[] arr;
    int cap;
    int top1;
    int top2;

    TwoStacks(int x) {
        arr = new int[x];
        cap = x;
        top1 = -1;
        top2 = cap;
    }

    void push1(int x) {
        if (top1<top2-1) {
            top1++;
            arr[top1] = x;
        }
        else {
            System.out.println("Stack overflow!");
            System.exit(1);
        }
    }

    void push2(int x) {
        if (top1 < top2-1) {
            top2--;
            arr[top2] = x;
        }
        else {
            System.out.println("Stack Overflow!");
            System.exit(1);
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else {
            System.out.println("Stack Underflow!");
            System.exit(1);
        }
        return 0;
    }

    int pop2() {
        if (top2 < cap) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else {
            System.out.println("Stack Underflow!");
            System.exit(1);
        }
        return 0;
    }
}

public class AddTwoStacksInAnArray {
    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(5);
        stacks.push1(2);
        stacks.push2(4);
        stacks.push1(9);
        stacks.push2(7);
        stacks.push1(4);
        System.out.println("Popped element from stack1 is: " + stacks.pop1());
        stacks.push2(40);
        System.out.println("Popped element from stack2 is: " + stacks.pop2());
    }
}
