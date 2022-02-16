import java.util.HashMap;

public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {5, 8, -4, -4, 9, -2, 2};
        System.out.println(maxLength(arr, arr.length, 0));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int maxLength(int arr[], int n, int sum) {
        int result = 0;
        for (int i=0; i<n; i++) {
            int currSum = 0;
            for (int j=i; j<n; j++) {
                currSum += arr[j];
                if (currSum==sum) {
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int maxLengthEfficient(int arr[], int n, int sum) {
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            prefixSum += arr[i];
            if (prefixSum==sum) {
                maxLength = i+1;
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            if (map.containsKey(prefixSum-sum)) {
                if (maxLength < i - map.get(prefixSum-sum)) {
                    maxLength = i - map.get(prefixSum-sum);
                }
            }
        }
        return maxLength;
    }
}
