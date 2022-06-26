public class DisjointUnionSets {
    int[] parent;
    int[] rank;
    int n;

    public DisjointUnionSets(int n) {
        parent = new int[1000];
        rank = new int[1000];
        this.n = n;
        makeSet();
    }

    public int findParent(int node) {
        if (node!=parent[node]) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }

    public void union(int u, int v) {
        u = findParent(u);
        v = findParent(v);

        if (rank[u]<rank[v]) {
            parent[u] =v;
        }
        else if (rank[u]>rank[v]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    public void makeSet() {
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static void main(String[] args) {
        DisjointUnionSets set = new DisjointUnionSets(5);
        set.union(0, 2);
        set.union(4, 2);
        set.union(3, 1);

        if (set.findParent(4)== set.findParent(0)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        if (set.findParent(1)== set.findParent(0)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}