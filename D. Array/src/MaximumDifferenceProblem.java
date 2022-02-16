// Write a program to find the maximum difference in an array.
public class MaximumDifferenceProblem {
    public static void main(String[] args) {
        System.out.println(maxDiffNaive(new int[]{3, 4, 10, 12, 11, 9, 22}));
        System.out.println(maxDiffEfficient((new int[]{2, 3, 10, 6, 4, 8, 1})));
    }

//    Time Complexity = O(n)
//    Auxiliary Space = O(1)
    public static int maxDiffEfficient(int arr[]) {
        int result = arr[1] - arr[0];
        int minValue = arr[0];
        for (int i=1; i<arr.length; i++) {
            result = Math.max(result, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return result;
    }

//    Time complexity = O(n^2)
//    Auxiliary Space = O(1)
    public static int maxDiffNaive(int arr[]) {
        int result = arr[1] - arr[0];
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                result = Math.max(result, arr[j]-arr[i]);
            }
        }
        return result;
    }
}
