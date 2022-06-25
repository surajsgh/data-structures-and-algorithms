//  ALGORITHM TO FIND STRONGLY CONNECTED COMPONENTS
//  STEP 1 : SORT ALL NODES IN THE ORDER OF FINISHING TIME
//  STEP 2 : TRANSPOSE THE GRAPH
//  STEP 3 : PERFORM DFS ACCORDING TO ACTUAL FINISHING TIME

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithms {
    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=0; i<V; i++) {
            list.add(new ArrayList<Integer>());
        }

        list.get(1).add(3);
        list.get(2).add(1);
        list.get(3).add(2);
        list.get(3).add(5);
        list.get(4).add(6);
        list.get(5).add(4);
        list.get(6).add(5);

        topologicalSort(list, V);
    }

    //  Time Complexity : O(V + E)
    //  Auxiliary Space : O(V)
    public static void topologicalSort(ArrayList<ArrayList<Integer>> list, int v) {
        //  STEP 1
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                dfs(list, visited, stack, i);
            }
        }

        //  STEP 2
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for (int i=0; i<v; i++) {
            transpose.add(new ArrayList<Integer>());
        }

        for (int i=0; i<v; i++) {
            visited[i] = false;
            for (int num : list.get(i)) {
                transpose.get(num).add(i);
            }
        }

        //  STEP 3
        while (stack.size()!=0) {
            int num = stack.pop();
            if (!visited[num]) {
                System.out.println("STT: ");
                dfsRev(visited, transpose, num);
                System.out.println();
            }
        }
    }

    public static void dfsRev(boolean[] visited, ArrayList<ArrayList<Integer>> list, int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int num : list.get(i)) {
            if (!visited[num]) {
                dfsRev(visited, list, num);
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, boolean[] visited, Stack<Integer> stack, int i) {
        visited[i] = true;

        for (int num : list.get(i)) {
            if (!visited[num]) {
                dfs(list, visited, stack, num);
            }
        }

        stack.push(i);
    }
}
