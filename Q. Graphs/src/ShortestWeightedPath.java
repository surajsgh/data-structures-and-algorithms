import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestWeightedPath {

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(v);

        for (int i=0; i<v; i++) {
            list.add(new ArrayList<>());
        }

        addList(list, 0, 1);
        addList(list, 1, 2);
        addList(list, 2, 3);
        addList(list, 0, 2);
        addList(list, 1, 3);

        int[] dist = new int[v];
        for (int i=0; i<v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        bfs(list, 0, v, dist);

        for (int i=0; i<v; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void addList(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static void bfs(ArrayList<ArrayList<Integer>> list, int s, int v, int[] dist) {
        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int n : list.get(num)) {
                if (!visited[n]) {
                    visited[n] = true;
                    dist[n] = dist[num] + 1;
                    queue.add(n);
                }
            }
        }
    }
}
