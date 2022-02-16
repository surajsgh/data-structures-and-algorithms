import java.util.Arrays;

public class DijiktrasAlgorithm {
    //  Shortest Path Algorithm
    //  Time Complexity : O(V*V)
    //  Auxiliary Space : O(V)
    public static int v = 4;
    public static int[] dijiktra(int[][] graph, int source) {
        int[] key = new int[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[source] = 0;

        boolean[] find = new boolean[v];

        for (int count=0; count<v-1; count++) {
            int u=-1;
            for (int i=0; i<v; i++) {
                if (!find[i] && (u==-1 || key[i]<key[u])) {
                    u=i;
                }
            }

            find[u] = true;

            for (int w=0; w<v; w++) {
                if (graph[u][w]!=0 && !find[w]) {
                    key[w] = Math.min(graph[u][w] + key[w], key[w]) ;
                }
            }
        }
        return key;
    }
}
