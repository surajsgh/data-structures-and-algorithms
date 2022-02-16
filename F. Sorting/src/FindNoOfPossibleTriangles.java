import java.util.Arrays;

// We could have solved this problem using brute-force strategy but it's time complexity would be O(n*n*n).
public class FindNoOfPossibleTriangles {
    public static void main(String[] args) {
        System.out.println(countTotalNoOfPossibleTriangle(new int[]{6, 4, 9, 7, 8}));
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static int countTotalNoOfPossibleTriangle(int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=arr.length-1; i>=0; i--) {
            int low = 0;
            int right = i-1;
            while (low < right) {
                if (arr[low] + arr[right] > arr[i]) {
                    count += right-low;
                    right--;
                }
                else {
                    low++;
                }
            }
        }
        return count;
    }
}
