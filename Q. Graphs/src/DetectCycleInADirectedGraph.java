import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static boolean dfs(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfsRec(list, i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsRec(ArrayList<ArrayList<Integer>> list, int S, boolean[] visited, boolean[] recStack) {
        visited[S] = true;
        recStack[S] = true;

        for (int u : list.get(S)) {
            if (!visited[u] && dfsRec(list, u, visited, recStack)) {
                return true;
            }
            else if (recStack[u]) {
                return true;
            }
        }

        recStack[S] = false;
        return false;
    }

    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static boolean detect(ArrayList<ArrayList<Integer>> list, int v) {
        int[] inDegree = new int[v];

        for (int i=0; i<v; i++) {
            for (int num : list.get(i)) {
                inDegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<v; i++) {
            if (inDegree[i]==0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int u : list.get(x)) {
                if (--inDegree[u]==0) {
                    queue.add(u);
                }
                count++;
            }
        }

        return count!=v;
    }
}
