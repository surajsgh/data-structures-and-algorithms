// A program to findout nth fibonacci number.
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(5));
    }

    public static int fibonacciSeries(int number) {
        if (number<=1) {
            return number;
        }
        return fibonacciSeries(number-1) + fibonacciSeries(number-2);
    }
}
