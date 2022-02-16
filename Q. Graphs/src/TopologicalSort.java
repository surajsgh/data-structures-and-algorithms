import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    //  KAHN'S BFS BASED ALGORITHM
    //  Time Complexity : O(V+E);
    //  Auxiliary Space : O(V)
    public static void topologicalSort(ArrayList<ArrayList<Integer>> list, int V) {
        int[] inDegree = new int[V];

        for (int i=0; i<V; i++) {
            for (int num : list.get(i)) {
                inDegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<V; i++) {
            if (inDegree[i]==0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int x : list.get(u)) {
                if (--inDegree[x]==0) {
                    queue.add(x);
                }
            }
        }
    }

    //  DFS BASED ALGORITHM
    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static void topologicalSortAlt(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(list, stack, visited, i);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, Stack<Integer> stack, boolean[] visited, int i) {
        visited[i] = true;

        for (int num : list.get(i)) {
            if (!visited[num]) {
                dfs(list, stack, visited, num);
            }
        }

        stack.push(i);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=0; i<V; i++) {
            list.add(new ArrayList<Integer>());
        }

        addEdge(list,0, 1);
        addEdge(list,1, 3);
        addEdge(list,2, 3);
        addEdge(list,3, 4);
        addEdge(list,2, 4);

        topologicalSortAlt(list, V);
    }
}
