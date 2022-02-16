import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = new int[]{18, 12, 13, 14, 11, 16};
        printSpan(arr, arr.length);
        System.out.println();
        printSpanEfficient(arr, arr.length);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void printSpanEfficient(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        System.out.print(1 + " ");
        for (int i=1; i<n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i+1 : i-stack.peek();
            System.out.print(span + " ");
            stack.push(i);
        }
    }

    //  Time Complexity : O(n**2)
    //  Auxiliary Space : O(1)
    public static void printSpan(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            int span = 1;
            for (int j=i-1; j>=0; j--) {
                if (arr[j]<=arr[i]) {
                    span++;
                }
            }
            System.out.print(span+" ");
        }
    }
}
