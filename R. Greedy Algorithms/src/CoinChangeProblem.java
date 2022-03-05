import java.util.Arrays;

public class CoinChangeProblem {
    //  Greedy Algorithm
    //  Not recommended though
    //  Time Complexity : O(n)
    private static int findOptimal(int[] arr, int n, int amount) {
        int res = 0;
        int count = 0;
        Arrays.sort(arr);

        for (int i=n-1; i>=0; i--) {
            if (arr[i]<=amount) {
                count = (int)Math.floor(amount/arr[i]);
                res += count;
                amount -= count*arr[i];
            }
            if (amount==0) break;
        }

        return res;
    }
}
