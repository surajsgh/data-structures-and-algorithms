public class AddTwoNumbersWithoutAnyArithmeticOperator {
    public static void main(String[] args) {
        System.out.println(add(2, 3));
    }

    //  Time Complexity : O(log(b))
    //  Auxiliary Space : O(1)
    public static int add(int a, int b) {
        while (b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
