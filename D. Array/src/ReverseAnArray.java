// Write a program to reverse an array.
import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        reverse(new int[]{3, 12, 22, 44});
    }

//    Time complexity : O(n)
//    Space Complexity : O(1)
    public static void reverse(int arr[]) {
        int initial = 0;
        int last = arr.length - 1;
        while (initial < last) {
            int temp = arr[initial];
            arr[initial] = arr[last];
            arr[last] = temp;
            initial++;
            last--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
