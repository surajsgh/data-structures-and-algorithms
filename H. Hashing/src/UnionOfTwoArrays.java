import java.util.HashSet;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {15, 20, 5, 15};
        int[] arr2 = {15, 15, 15, 20, 10};
        System.out.println(union(arr1, arr2));
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(n)
    public static int union(int[] arr1, int[] arr2) {
        HashSet<Integer> keys = new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            keys.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++) {
            keys.add(arr2[i]);
        }
        return keys.size();
    }
}
