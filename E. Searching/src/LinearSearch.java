import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{10, 10}, 10));
    }

//    Linear Search : We're comparing each element one by one with the given number.
//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int linearSearch(int arr[], int number) {
        int result=0;
        if (isSorted(arr)) {
            for (int i=0; i<arr.length; i++) {
                if (arr[i] == number) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isSorted(int arr[]) {
        if (arr[0] < arr[arr.length-1]) {
            for (int i=1; i<arr.length; i++) {
                if (arr[i-1] > arr[i]) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return true;
    }
}
