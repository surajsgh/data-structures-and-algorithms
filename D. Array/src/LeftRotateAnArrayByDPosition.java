// Write a program to rotate the elements to left direction by one position.
import java.util.Arrays;

public class LeftRotateAnArrayByDPosition {
    public static void main(String[] args) {
        leftRotateNaive(new int[]{4, 1, 2, 8, 10}, 3);
        leftRotateBetter(new int[]{3, 1, 22, 44, 11}, 4);
        leftRotateEfficient(new int[]{3, 1, 22, 44, 11}, 2);
    }

    //  For right rotation
    public void rotateRight(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverseRight(int[] nums, int start, int end) {
        while(end > start) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            end--;
            start++;
        }
    }

    //  For left rotation
//    Time Complexity : O(n)
//    Space Complexity : O(1)
//    Reversal Algorithm
    public static void leftRotateEfficient(int arr[], int D) {
//        arr = new int[]{2, 22, 44, 11, 5};
        reverse(arr, 0, D-1);
        reverse(arr, D, arr.length-1);
        reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int arr[], int initial, int last) {
        int temp = 0;
        while (initial < last) {
            temp = arr[initial];
            arr[initial] = arr[last];
            arr[last] = temp;
            initial++;
            last--;
        }
    }

////////////////////////////////////////////////////////////////////////////////////////
//    Time Complexity : O(n);
//    Auxiliary Space : O(D)
    public static void leftRotateBetter(int arr[], int D) {
        int temp[] = new int[D];
        for (int i=0; i<D; i++) {
            temp[i] = arr[i];
        }
        for (int i=D; i<arr.length; i++) {
            arr[i-D] = arr[i];
        }
        for (int i=0; i<D; i++) {
            arr[arr.length-D+i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }

/////////////////////////////////////////////////////////////////////////////////////////
//    Time Complexity : O(nD)
//    Auxiliary Space : O(1)
    public static void leftRotateNaive(int arr[], int D) {
        for (int i=1; i<=D; i++) {
            int temp = arr[0];
            for (int j=1; j<arr.length; j++) {
                arr[j-1] = arr[j];
            }
            arr[arr.length - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
