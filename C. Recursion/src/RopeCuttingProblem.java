public class RopeCuttingProblem {
    public static void main(String[] args) {
        System.out.println(maxPieces(5, 1, 2, 5));
    }

    //  Time Complexity : O(3**n)
    public static int maxPieces(int n, int a, int b, int c) {
        if (n==0) {
            return 0;
        }
        if (n<0) {
            return -1;
        }
        int res = Math.max(maxPieces(n-a, a, b, c), Math.max(maxPieces(n-b, a, b, c), maxPieces(n-c, a, b, c)));
        if (res<0) {
            return -1;
        }
        return res+1;
    }
}
