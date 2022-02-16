public class LongestEvenOddSubarray {
    public static void main(String[] args) {
        System.out.println(longestEvenOddSubArray(new int[]{10, 12, 8, 4, 5, 6, 9}));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int longestEvenOddSubArray(int arr[]) {
        int count = 1;
        int result = 1;
        for (int i=0; i<arr.length-1; i++) {
            if ((arr[i]%2==0 && arr[i+1]%2!=0) || (arr[i]%2!=0 && arr[i+1]%2==0)) {
                count++;
                result = Math.max(result, count);
            }
            else {
                count = 1;
            }
        }
        return result;
    }
}
