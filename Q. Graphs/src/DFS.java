import java.util.ArrayList;

public class DFS {
    public static void dfs(ArrayList<ArrayList<Integer>> list, int v, int s) {
        boolean[] visited = new boolean[v+1];
        dfsRec(list, s, visited);
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
