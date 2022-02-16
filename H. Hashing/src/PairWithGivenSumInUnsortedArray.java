import java.util.HashSet;

public class PairWithGivenSumInUnsortedArray {
    public static void main(String[] args) {
        int arr[] = {3, 2, 8, 15, -8};
        System.out.println(containPair(arr, arr.length, 17));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static boolean containPair(int arr[], int n, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(sum-i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
