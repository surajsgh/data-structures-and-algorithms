import java.util.Stack;

public class LargestRectangle {
    public static void main(String[] args) {
        int rows = 4;
        int columns = 4;

        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };

        System.out.println(largestRectangle(matrix, rows, columns));
    }

    public static int getMaxAreaEfficient(int[] arr) {
        int n = arr.length;
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

    //  Time Complexity : O(R*C)
    //  Auxiliary Space : O(C)
    public static int largestRectangle(int[][] arr, int rows, int columns) {
        int res = getMaxAreaEfficient(arr[0]);

        for (int i=1; i<rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            res = Math.max(res, getMaxAreaEfficient(arr[i]));
        }

        return res;
    }
}
