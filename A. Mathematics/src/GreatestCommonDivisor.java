// A program to find out the GCD or HCF of two numbers.
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(GCD(10, 15));
    }

    public static int GCD(int number1, int number2) {
        int result = Math.min(number1, number2);
        while (result > 0) {
            if ((number1 % result == 0) && (number2 % result == 0)) {
                break;
            }
            result--;
        }
        return result;
    }
}
