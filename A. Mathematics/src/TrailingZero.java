// Find out the number of the trailing zeros in the factorial of the program
public class TrailingZero {
    public static void main(String[] args) {
//        System.out.println(factorial(100));
        System.out.println(trailingZerosEfficient(100));
    }

//    This method may lead to overflow. Thus, We're gonna follow the efficient approach.
//    Time Complexity : O(n)
    public static int factorial(int number) {
        int factorial = 1;
        int count = 0;

        if (number == 0) {
            return 1;
        }

        for (int i=number; i>=1; i--) {
            factorial = factorial*i;
        }

        int temp = factorial;

        while ((temp % 10) == 0) {
            ++count;
            temp = temp/10;
        }
        return count;
    }

//    Time Complexity : O(log(n))
    public static int trailingZerosEfficient(int number) {
        int count = 0;
        for (int i=5; i<=number; i*=5) {
            count = count + number/i;
        }
        return count;
    }
}
