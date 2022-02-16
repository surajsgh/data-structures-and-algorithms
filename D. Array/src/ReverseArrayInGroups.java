import java.util.ArrayList;

public class ReverseArrayInGroups {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i += k) {
            int left = i;
            // to handle case when k is not multiple of n
            int right = Math.min(i + k - 1, n - 1);
            int temp;
            // reverse the sub-array [left, right]
            while (left < right) {
                temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left += 1;
                right -= 1;
            }
        }
    }
}
