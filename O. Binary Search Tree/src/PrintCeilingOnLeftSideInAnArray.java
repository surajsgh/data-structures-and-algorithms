import java.util.TreeSet;

public class PrintCeilingOnLeftSideInAnArray {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static void ceilingNaive(int[] arr, int n) {
        System.out.println(-1);
        for (int i=1; i<n; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j=0; j<i; j++) {
                if (arr[j]>=arr[i]) {
                    diff = Math.min(diff, arr[j]-arr[i]);
                }
            }
            if (diff==Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(arr[i]+diff);
            }
        }
    }

    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(n)
    public static void ceilingEff(int[] arr, int n) {
        System.out.println(-1);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[0]);

        for (int i=1; i<n; i++) {
            if (set.ceiling(arr[i])!=null) {
                System.out.println(set.ceiling(arr[i]));
            }
            else {
                System.out.println(-1);
            }
            set.add(arr[i]);
        }
    }
}
