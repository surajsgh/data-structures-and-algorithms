public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josephus(5, 3));
    }

    //  This is applicable only if the number starts from 0, not one.
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int josephusProblem(int n, int k) {
        if (n==1) {
            return 0;
        }
        else {
            return (josephusProblem(n-1, k) + k) % n;
        }
    }

    public static int josephus(int n, int k) {
        return josephusProblem(n, k) + 1;
    }
}
