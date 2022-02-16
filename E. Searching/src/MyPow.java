public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(4, 3));
    }

    public static double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        if (n<0) {
            if (n==Integer.MIN_VALUE) {
                n += 2;
            }
            n = -n;
            x = 1/x;
        }
        return (n%2==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
