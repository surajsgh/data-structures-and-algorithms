// A program to check whether the given number is power of two.
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOf2Naive(30));
        System.out.println(isPowerOf2BrianKerningamAlgo(62));
    }

    public static boolean isPowerOf2Naive(int number) {
        if (number==0 || number==1) {
            return false;
        }

        while (number != 1) {
            if (number % 2 != 0) {
                return false;
            }

            number = number/2;
        }
        return true;
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static boolean isPowerOf2BrianKerningamAlgo(int number) {
        if (number<=0) {
            return false;
        }

        return ((number&(number-1))==0);
    }
}
