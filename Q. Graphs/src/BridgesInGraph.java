import java.util.ArrayList;

public class BridgesInGraph {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for (int i=0; i<V; i++) {
            list.add(new ArrayList<Integer>());
        }

        addEdge(list, 0, 1);
        addEdge(list, 0, 2);
        addEdge(list, 1, 2);
        addEdge(list, 1, 3);
        addEdge(list, 3, 4);

        printBridges(list, V);
    }

    public static void printBridges(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] visited = new boolean[V];
        int[] timeOfInsertion = new int[V];
        int[] lowestTimeOfInsertion = new int[V];

        int count = 0;
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                bridgesInGraph(list, visited, timeOfInsertion, lowestTimeOfInsertion, i, -1, count);
            }
        }
    }

    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static void bridgesInGraph(ArrayList<ArrayList<Integer>> list, boolean[] visited, int[] timeOfInsertion, int[] lowestTimeOfInsertion, int i, int parent, int count) {
        visited[i] = true;
        timeOfInsertion[i] = lowestTimeOfInsertion[i] = count++;

        for (int num: list.get(i)) {
            if (num==parent) continue;
            if (!visited[num]) {
                bridgesInGraph(list, visited, timeOfInsertion, lowestTimeOfInsertion, num, i, count);
                lowestTimeOfInsertion[i] = Math.min(lowestTimeOfInsertion[i], lowestTimeOfInsertion[num]);
                if (lowestTimeOfInsertion[num]>timeOfInsertion[i]) {
                    System.out.println(i + " " + num);
                }
            }
            else {
                lowestTimeOfInsertion[i] = Math.min(lowestTimeOfInsertion[i], timeOfInsertion[num]);
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }
}
