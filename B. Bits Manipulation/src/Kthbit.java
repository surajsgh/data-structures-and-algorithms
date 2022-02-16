// A program to findout if the kth bit is set or not!
public class Kthbit {
    public static void main(String[] args) {
        kthBitUsingLeftShiftOperator(4, 3);
        kthBitUsingRightShiftOperator(5, 3);
    }

    public static void kthBitUsingLeftShiftOperator(int number, int k) {
        if ((number & (1 << (k - 1))) != 0) {
            System.out.println("SET");
        } else {
            System.out.println("NOT SET");
        }
    }

    public static void kthBitUsingRightShiftOperator(int number, int k) {
        if (((number>>(k-1)) & 1) == 1) {
            System.out.println("SET");
        }
        else {
            System.out.println("NOT SET");
        }
    }
}
