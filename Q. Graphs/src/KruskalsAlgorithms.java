import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node2 {
    private int u;
    private int v;
    private int weight;

    public Node2(int _u, int _v, int _weight) {
        u = _u;
        v = _v;
        weight = _weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}

class sortComparator implements Comparator<Node2> {
    @Override
    public int compare(Node2 o1, Node2 o2) {
        return o1.getWeight()-o2.getWeight();
    }
}

public class KruskalsAlgorithms {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node2> list = new ArrayList<Node2>(n);

        list.add(new Node2(0, 1, 2));
        list.add(new Node2(0, 3, 6));
        list.add(new Node2(1, 3, 8));
        list.add(new Node2(1, 2, 3));
        list.add(new Node2(1, 4, 5));
        list.add(new Node2(2, 4, 7));

        kruskalAlgo(list, n);
    }

    //  Time Complexity : O(VlogV) + O(V*4@)
    //  Auxiliary Space : O(V)
    public static void kruskalAlgo(ArrayList<Node2> list, int V) {
        Collections.sort(list, new sortComparator());
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i=0; i<V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int cost = 0;
        ArrayList<Node2> result = new ArrayList<Node2>();
        for (Node2 node : list) {
            if (parent(node.getU(), parent)!=parent(node.getV(), parent)) {
                cost += node.getWeight();
                result.add(node);
                union(node.getU(), node.getV(), parent, rank);
            }
        }

        System.out.println(cost);
        for (Node2 node : result) {
            System.out.print(node.getU() + " " + node.getV());
            System.out.println();
        }
    }

    public static int parent(int u, int[] parent) {
        if (u!=parent[u]) {
            parent[u] = parent(parent[u], parent);
        }
        return parent[u];
    }

    public static void union(int u, int v, int[] parent, int[] rank) {
        u = parent[u];
        v = parent[v];

        if (rank[u]<rank[v]) {
            parent[u] = v;
        }
        else if (rank[u]>rank[v]){
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
}
