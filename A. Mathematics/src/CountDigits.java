// A program to find out the number of digits in a number.
public class CountDigits {
    public static void main(String[] args) {
        System.out.println(count(192810));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static long count(long number) {
        long count=0;
        while (number!=0) {
            number = number/10;
            ++count;
        }
        return count;
    }

}
