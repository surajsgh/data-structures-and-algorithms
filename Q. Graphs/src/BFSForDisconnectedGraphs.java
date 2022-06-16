import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//  IN THIS SCENARIO, WE'RE NOT GIVEN ANY SOURCE VERTEX. THE GRAPH IS UNDIRECTED BUT IT COULD ALSO BE DISCONNECTED
public class BFSForDisconnectedGraphs {
    public static void bfs(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            System.out.print(item + " ");
            for (int num : list.get(item)) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    //  Time Complexity : O(V+E)
    //  Where, V = No of Vertices
    //  E = No of Edges
    public static void bfsDis(ArrayList<ArrayList<Integer>> list, int v) {
        boolean[] visited = new boolean[v+1];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                bfs(list, i, visited);
            }
        }
    }
}
