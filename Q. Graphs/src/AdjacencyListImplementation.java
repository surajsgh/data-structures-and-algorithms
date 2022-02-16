import java.util.ArrayList;

public class AdjacencyListImplementation {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

        for (int i=0; i<v; i++) {
            adj.add(new ArrayList<>());
        }
        adjList(adj, 0, 1);
        adjList(adj, 0, 2);
        adjList(adj, 1, 2);
        adjList(adj, 1, 3);
        printList(adj);
    }

    public static void adjList(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printList(ArrayList<ArrayList<Integer>> list) {
        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
