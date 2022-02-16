public class BestTimeToBuyAndSellTheStock2 {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int maxProfit(int[] prices) {
        int i = 0;
        int n = prices.length;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        while(i<n-1) {
            while(i<n-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while(i<n-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            maxProfit += peak-valley;
        }
        return maxProfit;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int maxProfitSimple(int[] prices) {
        int n = prices.length;
        int result = 0;

        for(int i=1; i<n; i++) {
            if(prices[i]>=prices[i-1]) {
                result += prices[i]-prices[i-1];
            }
        }

        return result;
    }
}
