public class MinimumCoinsToMakeAValue {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        System.out.println(minimumCoins(coins, coins.length, 30));
    }

    public static int minimumCoins(int[] arr, int n, int value) {
        if (value==0) return 0;
        int res = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            if (arr[i]<=value) {
                int subRes = minimumCoins(arr, n, value - arr[i]);
                if (subRes!=Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }

        return res;
    }
}
