public class MaximumCuts {
    public static void main(String[] args) {
        System.out.println(maximumCuts(5, 1, 2, 3));
    }

    //  Time Complexity : O(n)
    public static int maximumCuts(int length, int a, int b, int c) {
        int[] arr = new int[length+1];
        arr[0] = 0;

        for (int i = 1; i<length+1; i++) {
            arr[i] = -1;
            if (i-a>=0) arr[i] = Math.max(arr[i], arr[i-a]);
            if (i-b>=0) arr[i] = Math.max(arr[i], arr[i-b]);
            if (i-c>=0) arr[i] = Math.max(arr[i], arr[i-c]);
            if (arr[i]!=-1) {
                arr[i]++;
            }
        }

        return arr[length];
    }
}
