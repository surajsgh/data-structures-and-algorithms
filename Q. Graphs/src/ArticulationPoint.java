import java.util.ArrayList;

public class ArticulationPoint {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(V);

        for (int i=0; i<V; i++) {
            list.add(new ArrayList<Integer>());
        }

        addEdge(list, 1, 0);
        addEdge(list, 0, 2);
        addEdge(list, 2, 1);
        addEdge(list, 0, 3);
        addEdge(list, 3, 4);

        articulationPoint(list, V);
    }

    //  Time Complexity : O(V+E)
    //  Auxiliary Space : O(V)
    public static void articulationPoint(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] visited = new boolean[V];
        int[] timeOfInsertion = new int[V];
        int[] lowestTimeOfInsertion = new int[V];
        int[] articulationPoint = new int[V];
        int count = 0;
        int parent = -1;

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                dfs(list, i, parent, count, visited, timeOfInsertion, lowestTimeOfInsertion, articulationPoint);
            }
        }

        for (int i=0; i<V; i++) {
            if (articulationPoint[i]==1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, int i, int parent, int count, boolean[] visited, int[] timeOfInsertion, int[] lowestTimeOfInsertion, int[] articulationPoint) {
        visited[i] = true;
        timeOfInsertion[i] = lowestTimeOfInsertion[i] = ++count;
        int child = 0;

        for (int num : list.get(i)) {
//            if (num==parent) continue;
            if (!visited[num]) {
                child++;
                dfs(list, num, i, count, visited, timeOfInsertion, lowestTimeOfInsertion, articulationPoint);
                lowestTimeOfInsertion[i] = Math.min(lowestTimeOfInsertion[i], lowestTimeOfInsertion[num]);
                if (lowestTimeOfInsertion[num]>=timeOfInsertion[i] && parent!=-1) {
                    articulationPoint[i] = 1;
                }
            }
            else {
                lowestTimeOfInsertion[i] = Math.min(lowestTimeOfInsertion[i], timeOfInsertion[num]);
            }
        }

        if (parent==-1 && child>1) {
            articulationPoint[i] = 1;
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> list, int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }
}
