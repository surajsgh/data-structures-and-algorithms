import java.util.Arrays;

public class RearrangeTheArrayAlternatively {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(arr));
        arrange(arr);
        System.out.println(Arrays.toString(arr));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(n)
    public static void arrange(int[] arr) {
        int[] temp = arr.clone();
        int initial = 0;
        int end = arr.length-1;
        boolean flag = true;

        for (int i=0; i<arr.length; i++) {
            if (flag) {
                arr[i] = temp[end];
                end--;
            }
            else {
                arr[i] = temp[initial];
                initial++;
            }
            flag = !flag;
        }
    }
}
