// A program to find out the number of prime factors.
public class PrimeFactors {
    public static void main(String[] args) {
        primeFactors(450);
        primeFactorsAlt(450);
    }

    //  Time Complexity : O(Math.sqrt(n))
    //  Auxiliary Space : O(1)
    public static void primeFactorsAlt(int number) {
        while (number%2==0) {
            System.out.print(2 + " ");
            number/=2;
        }
        for (int i=3; i*i<=number; i+=2) {
            while(number%i==0) {
                System.out.print(i + " ");
                number/=i;
            }
        }
        if (number>2) {
            System.out.print(number);
        }
    }

    public static void primeFactors(int number) {
        //  Time Complexity : O(Math.sqrt(n))
        //  Auxiliary Space : O(1)
        /* More optimized solution
        for(int i=2; i*i<=n; i++) {
            while(n%i==0) {
                print(i);
                n=n/i;
            }
        }
        if(n>1) {
            print(n);
        }
        */
        //  Time Complexity : O(n*n(log(n)))
        //  Auxiliary Space : O(1)
        for (int i=2; i<number; i++) {
            if (isPrime(i)) {
                int x = i;
                while (number%x == 0) {
                    System.out.println(i);
                    x = x*i;
                }
            }
        }
    }

    public static boolean isPrime(int number) {

//        Most efficient method
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
