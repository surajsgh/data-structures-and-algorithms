import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 30, 10, 5, 15};
        findPreviousGraterElement(arr, arr.length);
        System.out.println();
        findPrevGreaterElementEfficient(arr, arr.length);
    }

    //  Time Complexity : O(n**2)
    //  Auxiliary Space : O(1)
    public static void findPreviousGraterElement(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            int j;
            for (j=i-1; j>=0; j--) {
                if (arr[i]<arr[j]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if (j == -1) {
                System.out.print(-1 + " ");
            }
        }
    }

    public static void findPrevGreaterElementEfficient(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i=1; i<n; i++) {
            while (!stack.isEmpty() && stack.peek()<arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(span + " ");
            stack.push(arr[i]);
        }
    }
}
