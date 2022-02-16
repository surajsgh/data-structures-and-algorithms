public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary space : O(1)
    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1) {
            return 1;
        }
        m--;
        n--;
        if (m<n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i=m+1; i<=m+n; i++, j++) {
            res *= i;
            res /= j;
        }
        return (int)res;
    }
}
