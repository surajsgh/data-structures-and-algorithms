import java.util.Arrays;

class MakeArithmeticProgression {
//   Time Complexity : O(n)
//   Auxiliary Space : O(1)
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length<=2) {
            return true;
        }
        int result = arr[1] - arr[0];
        for(int i=2; i<arr.length; i++) {
            if(result == arr[i]-arr[i-1]) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 4};
        System.out.println(canMakeArithmeticProgression(arr));
    }
}
