import java.util.Stack;

public class LargestRectangularArea {
    public static void main(String[] args) {
        int arr[] = new int[]{6, 2, 5, 4, 1, 5, 6};
        System.out.println(getMaxArea(arr, arr.length));
        System.out.println(getMaxAreaEfficient(arr, arr.length));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int getMaxAreaEfficient(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int res=0;
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                int tp = stack.pop();
                int curr = arr[tp]*(stack.isEmpty() ? i:(i-stack.peek()-1));
                res = Math.max(res, curr);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int tp = stack.pop();
            int curr = arr[tp]*(stack.isEmpty() ? n : (n-stack.peek()-1));
            res = Math.max(res, curr);
        }
        return res;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int getMaxArea(int[] arr, int n) {
        int res = 0;
        for (int i=0; i<n; i++) {
            int curr = arr[i];
            for (int j=i-1; j>=0; j--) {
                if (arr[j]>=arr[i]) {
                    curr += arr[i];
                }
                else {
                    break;
                }
            }
            for (int j=i+1; j<n; j++) {
                if (arr[j]>=arr[i]) {
                    curr += arr[i];
                }
                else {
                    break;
                }
            }
            res = Math.max(curr, res);
        }
        return res;
    }
}
