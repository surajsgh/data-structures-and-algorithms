// Write a program to move zeros to the end in an array.
import java.util.ArrayList;
import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        moveTheZerosNaive(new int[]{3, 1, 0, 0, 10, 0});
        moveZerosEfficient(new int[]{10, 12, 0, 0, 22, 0, 11});
    }

//    Time Complexity : O(n^2)
//    Auxiliary Space : O(1)
    public static void moveTheZerosNaive(int arr[]) {
        int temp = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0) {
                for (int j=i+1; j<arr.length; j++) {
                    if (arr[j]!=0) {
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static void moveZerosEfficient(int arr[]) {
        int count = 0;
        int temp = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=0) {
                temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
