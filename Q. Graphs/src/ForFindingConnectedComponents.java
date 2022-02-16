import java.awt.image.ImageConsumer;
import java.util.ArrayList;

public class ForFindingConnectedComponents {
    //  Number of islands problem using DFS
    public static void dfs(ArrayList<ArrayList<Integer>> list, int v, int s) {
        boolean[] visited = new boolean[v+1];
        for (int i=0; i<v; i++) {
            if (visited[i]==false) {
                dfsRec(list, i, visited);
            }
        }
    }

    //  Time Complexity : O(V+E)
    public static int dfsRec(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
        int count = 0;
        visited[s] = true;
        System.out.print(s + " ");
        for (int num : list.get(s)) {
            if (visited[num]==false) {
                dfsRec(list, num, visited);
                count++;
            }
        }
        return count;
    }
}
