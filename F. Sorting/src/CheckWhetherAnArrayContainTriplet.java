import java.util.Arrays;

public class CheckWhetherAnArrayContainTriplet {

    public static void main(String[] args) {
        int arr[] = new int[]{4, -16, 43, 4, 7, -36, 18};
        System.out.println(findTriplets(arr, arr.length));
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static boolean findTriplets(int arr[] , int n)
    {
        int sum = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length-1; i++) {
            int low = i + 1;
            int high = arr.length-1;
            while(low < high) {
                sum = arr[low] + arr[high] + arr[i];
                if(sum < 0) {
                    low++;
                }
                else if (sum > 0) {
                    high--;
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

}
