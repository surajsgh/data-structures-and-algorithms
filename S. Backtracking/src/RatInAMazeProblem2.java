import java.util.ArrayList;

public class RatInAMazeProblem2 {
    //  Time Complexity : O(4^(m*n))
    //  Auxiliary Space : O(m*n)
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                visited[i][j] = 0;
            }
        }

        ArrayList<String> list = new ArrayList<String>();
        if(m[0][0]==1) findRec(0, 0, m, n, list, "", visited);
        return list;
    }

    public static void findRec(int i, int j, int[][] m, int n, ArrayList<String> list, String str, int[][] visited) {
        if(i==n-1 && j==n-1) {
            list.add(str);
            return;
        }

        //  DOWN
        if(i+1<n && m[i+1][j]==1 && visited[i+1][j]==0) {
            visited[i][j]=1;
            findRec(i+1, j, m, n, list, str+"D", visited);
            visited[i][j]=0;
        }

        //  LEFT
        if(j-1>=0 && m[i][j-1]==1 && visited[i][j-1]==0) {
            visited[i][j]=1;
            findRec(i, j-1, m, n, list, str+"L", visited);
            visited[i][j]=0;
        }

        //  RIGHT
        if(j+1<n && m[i][j+1]==1 && visited[i][j+1]==0) {
            visited[i][j]=1;
            findRec(i, j+1, m, n, list, str+"R", visited);
            visited[i][j]=0;
        }

        //  UP
        if(i-1>=0 && m[i-1][j]==1 && visited[i-1][j]==0) {
            visited[i][j]=1;
            findRec(i-1, j, m, n, list, str+"U", visited);
            visited[i][j]=0;
        }
    }
}
