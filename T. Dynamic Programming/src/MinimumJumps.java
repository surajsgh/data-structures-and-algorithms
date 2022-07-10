public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 1};
        System.out.println(minimumJumps(arr, arr.length));
        System.out.println(minimumJumpsEff(arr, arr.length));
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

    //  Time Complexity : O(n^2)
    //  Auxiliary Space : O(n)
    public static int minimumJumpsEff(int[] arr, int n) {
        int[] sol = new int[n];
        sol[0] = 0;

        for (int i=1; i<n; i++) {
            sol[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (j+arr[j]>=i) {
                    sol[i] = Math.min(sol[i], sol[j]+1);
                }
            }
        }

        return sol[n-1];
    }
}
