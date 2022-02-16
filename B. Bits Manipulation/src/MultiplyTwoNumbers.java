import java.sql.Time;

public class MultiplyTwoNumbers {
    //  Time Complexity : O(log(b))
    //  Auxiliary Space : O(1)
    public static int multiply(int a, int b) {
        int res = 0;
        while (b!=0) {
            if ((b&1)!=0) {
                res += a;
            }
            a <<= 1;
            b >>= 1;
        }
        return res;
    }
}
