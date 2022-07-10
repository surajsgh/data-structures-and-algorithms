//  You can also use the same strategy to make an unsorted array into the sorted one.
//  All you have to do is just use the below function and subtract the final result from length of the total array.
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        int n = arr.length;
        System.out.println(longestIncreasingSubsequenceNaive(arr, n));
        System.out.println(longestIncreasingSubsequenceEff(arr, n));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(n)
    public static int longestIncreasingSubsequenceNaive(int[] arr, int n) {
        int[] list = new int[n];
        list[0] = 1;

        for (int i=1; i<n; i++) {
            list[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[j]<arr[i]) {
                    list[i] = Math.max(list[i], list[j]+1);
                }
            }
        }

        int res = list[0];
        for (int i=1; i<n; i++) {
            res = Math.max(res, list[i]);
        }

        return res;
    }

    //  Time Complexity : O(NlogN)
    //  Auxiliary Space : O(N)
    public static int longestIncreasingSubsequenceEff(int[] arr, int n) {
        int[] list = new int[n];
        list[0] = arr[0];
        int index = 1;

        for (int i=1; i<n; i++) {
            if (list[index-1]<arr[i]) {
                list[index++] = arr[i];
            }
            else {
                int element = binarySearch(arr, 0, n-1, arr[i]);
                list[element] = arr[i];
            }
        }

        return index;
    }

    public static int binarySearch(int[] arr, int low, int high, int x) {
        while (low<high) {
            int mid = (low + high) / 2;
            if (arr[mid]>x) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return high;
    }
}
