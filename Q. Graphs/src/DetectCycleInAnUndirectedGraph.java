import java.util.ArrayList;

public class DetectCycleInAnUndirectedGraph {
    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static boolean dfs(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] visited = new boolean[V];

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfsRec(list, i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsRec(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited, int parent) {
        visited[s] = true;

        for (int v : list.get(s)) {
            if (!visited[v]) {
                if (dfsRec(list, v, visited, s)) {
                    return true;
                }
            }
            else if (v!=parent) {
                return true;
            }
        }

        return false;
    }
}
