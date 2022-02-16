public class CapacityToShipPackagesWithinDDays {
    //  Time Complexity : O(nlog(sum))
    //  Auxiliary Space : O(1)
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max;
        int high = sum;
        int res = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(isFeasible(weights, n, days, mid)) {
                res = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static boolean isFeasible(int[] weights, int n, int days, int ans) {
        int currSum = 0;
        int req = 1;
        for(int i=0; i<n; i++) {
            if(currSum+weights[i]>ans) {
                req++;
                currSum = weights[i];
            }
            else {
                currSum += weights[i];
            }
        }
        return (req<=days);
    }
}
