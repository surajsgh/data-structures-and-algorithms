public class EditDistanceProblem {
    public static void main(String[] args) {
        System.out.println(editDistanceNaive("CAT", "CUT", 3, 3));
    }

    //  Time Complexity : O(3^m)
    public static int editDistanceNaive(String first, String second, int m, int n) {
        if (m==0) return n;
        if (n==0) return m;
        if (first.charAt(m-1)==second.charAt(n-1)) {
            return editDistanceNaive(first, second, m-1, n-1);
        }
        return 1 + Math.min(editDistanceNaive(first, second, m-1, n), Math.min(editDistanceNaive(first, second, m, n-1), editDistanceNaive(first, second, m-1, n-1)));
    }
}
