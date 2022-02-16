public class FindTwoRepeatingElementsInAGivenArray {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
        find(arr, arr.length);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void find(int[] arr, int n) {
        for (int i=0; i<n; i++) {
            if (arr[Math.abs(arr[i])]>0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                System.out.print(arr[Math.abs(arr[i])] + " ");
            }
        }
    }
}
