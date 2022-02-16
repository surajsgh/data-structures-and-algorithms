import java.util.HashMap;

public class LongestSubarrayWithEqualNoOfZerosAndOnes {
    public static void main(String[] args) {
        int arr[] = {1, 0};
        System.out.println(find(arr, arr.length));
        System.out.println(findEfficient(arr, arr.length));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int find(int[] arr, int n) {
        int result = 0;
        for (int i=0; i<n; i++) {
            int C0 = 0;
            int C1 = 0;
            for (int j=i; j<n; j++) {
                if (arr[j]==0) {
                    C0++;
                }
                else {
                    C1++;
                }
                if (C0==C1) {
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int findEfficient(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i=0; i<n; i++) {
            count = count + (arr[i]==1?1:-1);
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i-map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
