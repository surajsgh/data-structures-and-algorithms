public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBitsDecimal(11));
    }

    //  This method is only applicable for decimal numbers, not for binary numbers.
    //  Time Complexity : O(log(n))
    //  Auxiliary Space : O(1)
    public static int reverseBitsDecimal(int n) {
        int rev = 0;
        while(n!=0) {
            rev <<= 1;
            if ((n&1)!=0) {
                rev ^= 1;
            }
            n >>= 1;
        }
        return rev;
    }

    //  This method is only applicable for binary numbers, not for decimal.
    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public static long reverseBitsBinary(long number) {
        long result = 0;
        for (int i=0; i<32; i++){
            result = (long)(result<<1 | number&1);
            number >>= 1;
        }
        return result;
    }
}
