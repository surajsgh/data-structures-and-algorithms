// Write a program to move the elements of an array to the left by one position.
import java.util.Arrays;

public class LeftRotateAnArrayByOne {
    public static void main(String[] args) {
        rotateLeftByOnePosition(new int[]{3, 2, 22, 44, 11});
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static void rotateLeftByOnePosition(int arr[]) {
        int temp = arr[0];
        for (int i=1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
