// A program to find out the factorial of a given number.
public class FactorialNumber {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int factorial(int number) {
        int factorial = 1;

        if (number == 0) {
            return 1;
        }

        for (int i=number; i>=1; i--) {
            factorial = factorial*i;
        }

        return factorial;
    }
}
