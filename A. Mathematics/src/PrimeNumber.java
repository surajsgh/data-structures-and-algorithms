// Program to check whether the given number is prime or not.
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(1031));
    }

    //  Time Complexity : O(Math.sqrt(n))
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i=2; i*i<=number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    //  Most efficient method
    //  Time Complexity : O(Math.sqrt(n))
    public static boolean isPrimeEfficient(int number) {
        if (number == 1) {
            return false;
        }

        if (number==2 || number==3) {
            return true;
        }

        if (number%2==0 || number%3==0) {
            return false;
        }

        for (int i=5; i*i<=number; i+=6) {
            if (number%i==0 || number%(i+2)==0) {
                return false;
            }
        }
        return true;
    }
}
