public class SpecialKeyboards {
    public static void main(String[] args) {
        System.out.println(optimalKeys(7));
    }

    //  Solve this problem later using dynamic programming for efficient approach.
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(n)
    public static int optimalKeys(int N) {
        if (N<=6) {
            return N;
        }
        int max = 0;
        int b;
        for (b=N-3; b>=1; b--) {
            int curr = (N-b-1)*optimalKeys(b);
            if (curr>max) {
                max = curr;
            }
        }
        return max;
    }
}
