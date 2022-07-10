public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 1};
        System.out.println(minimumJumps(arr, arr.length));
    }

    public static int minimumJumps(int[] arr, int n) {
        if (n==1) return 0;
        int res = Integer.MAX_VALUE;

        for (int i=0; i<n-1; i++) {
            if (i+arr[i]>=n-1) {
                int subRes = minimumJumps(arr, i+1);
                if (subRes!=Integer.MAX_VALUE) {
                    res = Math.min(res, subRes+1);
                }
            }
        }

        return res;
    }
}
