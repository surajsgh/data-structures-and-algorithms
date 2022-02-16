import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {10, 15, 20, 15, 30, 30, 5};
        int[] arr2 = {30, 5, 30, 80};
        System.out.println(intersectionOfTwoArrays(arr1, arr2));
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(n)
    public static int intersectionOfTwoArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> keys = new HashSet<>();
        for (int i=0; i<arr1.length; i++) {
            keys.add(arr1[i]);
        }
        int count = 0;
        for (int j=0; j<arr2.length; j++) {
            if (keys.contains(arr2[j])) {
                count++;
                keys.remove(arr2[j]);
            }
        }
        return count;
    }
}
