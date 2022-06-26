//  A LITTLE BIT OF MORE MODIFICATION OVER DIJKSTRA'S ALGORITHM
//  ALSO CONSIDERS EDGES WITH NEGATIVE WEIGHT, SOMETHING DIJKSTRA'S ALGO FAILS

import java.util.ArrayList;
import java.util.Arrays;

class Node {
    private int u;
    private int v;
    private int distance;

    public Node(int _u, int _v, int _distance) {
        u = _u;
        v = _v;
        distance = _distance;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getDistance() {
        return distance;
    }
}

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int V = 6;

        ArrayList<Node> list = new ArrayList<Node>();
        list.add(new Node(3, 2, 6));
        list.add(new Node(5, 3, 1));
        list.add(new Node(0, 1, 5));
        list.add(new Node(1, 5, -3));
        list.add(new Node(1, 2, -2));
        list.add(new Node(3, 4, -2));
        list.add(new Node(2, 4, 3));

        bellmanFordAlgo(list, V, 0);
    }

    //  Time Complexity : O(VE)
    //  Auxiliary Space : O(V)
    public static void bellmanFordAlgo(ArrayList<Node> list, int v, int src) {
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i=1; i<=v-1; i++) {
            for (Node node : list) {
                if (distance[node.getU()] + node.getDistance() < distance[node.getV()]) {
                    distance[node.getV()] = distance[node.getU()] + node.getDistance();
                }
            }
        }

        int count = 0;
        for (Node node : list) {
            if (distance[node.getU()] + node.getDistance() < distance[node.getV()]) {
                count = 1;
                System.out.println("Cycle exists");
                break;
            }
        }

        if (count==0) {
            for (int i=0; i<v; i++) {
                System.out.print(distance[i] + " ");
            }
        }
    }
}
