import java.awt.image.ImageConsumer;
import java.util.ArrayList;

public class ForFindingConnectedComponents {
    //  Number of islands problem using DFS
    public static int dfs(ArrayList<ArrayList<Integer>> list, int v, int s) {
        int count = 0;
        boolean[] visited = new boolean[v+1];
        for (int i=0; i<v; i++) {
            if (visited[i]==false) {
                dfsRec(list, i, visited);
                count++;
            }
        }
        return count;
    }

    //  Time Complexity : O(V+E)
    public static void dfsRec(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int num : list.get(s)) {
            if (visited[num]==false) {
                dfsRec(list, num, visited);
            }
        }
    }
}
