import java.util.HashSet;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int arr[] = new int[]{4, -3, 2, 1};
        System.out.println(compare(arr, arr.length));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Sum : O(1)
    public static boolean compare(int arr[], int n) {
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += arr[j];
                if (sum==0) {
                    return true;
                }
            }
        }
        return false;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static boolean compareEfficient(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i : arr) {
            prefixSum += i;
            if (set.contains(prefixSum)) {
                return true;
            }
            if (prefixSum==0) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }
}
