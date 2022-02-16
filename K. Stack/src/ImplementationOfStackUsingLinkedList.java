import com.sun.security.auth.UnixNumericGroupPrincipal;

class ListNode {
    int data;
    ListNode next;

    ListNode(int x) {
        data = x;
        next = null;
    }
}

class StackInstance {
    ListNode head;
    int size;

    StackInstance() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return head==null;
    }

    void push(int x) {
        ListNode node = new ListNode(x);
        node.next =  head;
        head = node;
        size++;
    }

    int pop() {
        if (head==null) return Integer.MAX_VALUE;
        int nodeData = head.data;
        ListNode node = head;
        head = head.next;
        node = null;
        size--;
        return nodeData;
    }

    int peek() {
        if (head==null) return Integer.MAX_VALUE;
        return head.data;
    }
}

public class ImplementationOfStackUsingLinkedList {
    public static void main(String[] args) {
        StackInstance stackInstance = new StackInstance();
        System.out.println(stackInstance.isEmpty());
        stackInstance.push(10);
        stackInstance.push(20);
        stackInstance.push(30);
        System.out.println(stackInstance.peek());
        System.out.println(stackInstance.size());
        System.out.println(stackInstance.isEmpty());
        System.out.println(stackInstance.pop());
        System.out.println(stackInstance.peek());
    }
}