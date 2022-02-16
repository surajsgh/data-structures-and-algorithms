import java.util.HashSet;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {5, 8, 6, 13, 3, -1};
        System.out.println(isSum(arr, arr.length, 22));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static boolean isSum(int[] arr, int n, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i:arr) {
            prefixSum += i;
            if (sum==prefixSum) {
                return true;
            }
            if(set.contains(prefixSum-sum)) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }
}
