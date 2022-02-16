public class SubtractOneNumberFromAnother {
    //  Time Complexity : O(log(b))
    //  Auxiliary Space : O(1)
    public static int subtract(int a, int b) {
        while (b!=0) {
            int borrow = ~(a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
}
