// A program to print all divisors of a number.
public class Divisors {
    public static void main(String[] args) {
        allDivisorsOfANumber(100);
    }

//    Time Complexity : O(n^0.5)
//    Auxiliary Space : O(1)
    public static void allDivisorsOfANumber(int number) {
        for (int i=1; i*i<=number; i++) {
            if (number%i == 0) {
                System.out.println(i);
                if (i != number/i) {
                    System.out.println(number/i);
                }
            }
        }
    }
}
