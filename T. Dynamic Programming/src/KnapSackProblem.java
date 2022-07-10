public class KnapSackProblem {
    public static void main(String[] args) {
        int[] arr = {10, 40, 30, 50};
        int[] weights = {5, 4, 6, 3};
        int weight = 10;
        int n = 4;
        System.out.println(knapSackProblem(weights, arr, weight, n));
    }

    public static int knapSackProblem(int[] weights, int[] values, int weight, int n) {
        if (n==0 || weight==0) return 0;
        if (weights[n-1]>weight) {
            return knapSackProblem(weights, values, weight, n-1);
        }
        else {
            return Math.max(knapSackProblem(weights, values, weight, n-1), (knapSackProblem(weights, values, weight-weights[n-1], n-1) + values[n-1]));
        }
    }
}
