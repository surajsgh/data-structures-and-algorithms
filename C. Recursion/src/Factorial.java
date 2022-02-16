public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialAlternative(4, 1));
    }

//    This method is not trail recursive. That's why it executes slowly.
    public static int factorial(int number) {
        if (number==0 || number==1) {
            return 1;
        }
        return number*factorial(number-1);
    }

//    This method is trail recursive.
    public static int factorialAlternative(int number, int k) {
        if (number==0 || number==1) {
            return k;
        }
        return factorialAlternative(number-1, k*number);
    }
}
