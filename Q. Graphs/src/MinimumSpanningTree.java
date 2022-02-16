import java.util.Arrays;

public class MinimumSpanningTree {
    static int V = 4;
    //  Time Complexity : O(V*V)
    //  Auxiliary Space : O(V)
    public static int printMST(int[][] grid) {
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        boolean[] mSet = new boolean[V];
        int res = 0;

        for (int count = 0; count<V; count++) {
            int u = -1;

            for (int i=0; i<V; i++) {
                if (!mSet[i] && (u==-1 || key[u]<key[i])) {
                    u = i;
                }
            }

            mSet[u] = true;
            res += key[u];

            for (int v = 0; v<V; v++) {
                if (grid[u][v]!=0 && !mSet[v]) {
                    key[v] = Math.min(grid[u][v], key[v]);
                }
            }
        }

        return res;
    }
}
