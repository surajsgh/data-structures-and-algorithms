public class MaximumValueOfDifferencePairOfElementsAndTheirIndexes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(maxValue(arr, arr.length));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int maxValue(int[] arr, int N) {
        int res = 0;
        for (int i=0; i<N; i++) {
            for (int j=i; j<N; j++) {
                res = Math.max(res, (Math.abs(arr[i]-arr[j]) + Math.abs(i-j)));
            }
        }
        return res;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int maxValueEfficient(int[] arr, int N) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            max1 = Math.max(max1, arr[i]+i);
            min1 = Math.min(min1, arr[i]+i);
            max2 = Math.max(max2, arr[i]-i);
            min2 = Math.min(min2, arr[i]-i);
        }

        return Math.max(max1-min1, max2-min2);
    }
}
