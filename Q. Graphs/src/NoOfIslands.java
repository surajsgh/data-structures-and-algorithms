import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    public static void bfs(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
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

    //  Time Complexity : O(V+E)
    //  Where, V = No of Vertices
    //  E = No of Edges
    public static int bfsDis(ArrayList<ArrayList<Integer>> list, int v) {
        int count = 0;
        boolean[] visited = new boolean[v+1];
        for (int i=0; i<v; i++) {
            if (visited[i]==false) {
                bfs(list, i, visited);
                count++;
            }
        }
        return count;
    }

    //  LEETCODE
    /*

    //  Time Complexity : O(m*n)
    //  Auxiliary Space : O(1)
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void helper(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0') return;
        grid[i][j] = '0';
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, j+1);
        helper(grid, i, j-1);
    }
    */
}
