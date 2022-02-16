public class BestTimeToBuyAndSellTheStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.print(maxProfitNaive(arr));
        System.out.println();
        System.out.println(maxProfitEfficient(arr));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int maxProfitNaive(int[] arr) {
        int n = arr.length;
        int maxProfit = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                maxProfit = Math.max(maxProfit, arr[j]-arr[i]);
            }
        }
        return maxProfit;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int maxProfitEfficient(int[] prices) {
        if(prices.length==1) {
            return 0;
        }
        int n = prices.length;
        int maxProfit = prices[1]-prices[0];
        int minPrice = prices[0];
        for(int i=1; i<n; i++) {
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        maxProfit = maxProfit < 0 ? 0 : maxProfit;
        return maxProfit;
    }
}
