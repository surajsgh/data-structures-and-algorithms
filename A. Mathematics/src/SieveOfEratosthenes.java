// A program to implement Sieve of Eratosthenes to find out the prime numbers.

import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        sieve(20);
    }

    //  Time Complexity : O(n*log(log(n))) 
    public static void sieve(int number) {
        boolean isPrime[] = new boolean[number+1];
        Arrays.fill(isPrime, true);
        for (int i=2; i*i<=number; i++) {
            if (isPrime[i]) {
                for (int j=2*i; j<=number; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i=2; i<=number; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
    
    //  Here, we do use traditional way of writing isPrime() method.(Refer prime number program in mathematic repository.)
    //  Time Complexity : O(n * Math.sqrt(n))
//    public static void print(int number) {
//        for(int i=2; i<n; i++) {
//            if(isPrime(i)) {
//                System.out.println(i);
//            }
//        }
//    }
}
