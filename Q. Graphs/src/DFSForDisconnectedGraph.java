import java.util.ArrayList;

public class DFSForDisconnectedGraph {
    public static void dfs(ArrayList<ArrayList<Integer>> list, int v, int s) {
        boolean[] visited = new boolean[v+1];
        for (int i=0; i<v; i++) {
            if (visited[i]==false) {
                dfsRec(list, i, visited);
            }
        }
    }

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
