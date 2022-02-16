import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //  IF all the graph nodes are connected to eachother.
    public static void bfs(ArrayList<ArrayList<Integer>> list, int s, int v) {
        boolean visited[] = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            System.out.print(item + " ");
            for (int num : list.get(item)) {
                if (visited[num]==false) {
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}
