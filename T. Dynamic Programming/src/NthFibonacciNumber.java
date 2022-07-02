import java.util.Arrays;

public class NthFibonacciNumber {
    public static int num = 3;
    public static int[] memo = new int[num+1];

    public static void main(String[] args) {
        Arrays.fill(memo, -1);
        System.out.println(findNthFibonacciNumberNaive(num));
        System.out.println(findNthFibonacciEff(num));
        System.out.println(findNthFibonacciEff2(num));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int findNthFibonacciEff2(int n) {
        int memo[] = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i=2; i<=n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    //  Memoization Technique
    //  Time Complexity : O(n)
    public static int findNthFibonacciEff(int n) {
        if (memo[n]==-1) {
            int res;
            if (n<=1) {
                res = n;
            }
            else {
                res = findNthFibonacciEff(n-1) + findNthFibonacciEff(n-2);
            }
            memo[n] = res;
        }
        return memo[n];
    }

    //  Time Complexity : O(2**n)
    public static int findNthFibonacciNumberNaive(int n) {
        if (n<=1) {
            return n;
        }
        return findNthFibonacciNumberNaive(n-1) + findNthFibonacciNumberNaive(n-2);
    }
}
