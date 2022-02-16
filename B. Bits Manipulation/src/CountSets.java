public class CountSets {
    public static void main(String[] args) {
        System.out.println(countSetsNaive(5));
        System.out.println(countSetsBrianKerningamAlgo(8));
    }

    //  Time Complexity : O(Total number of bits)
    public static int countSetsNaive(int number) {
        int result=0;
        while (number>0) {
            if ((number&1)==1) {
                result++;
            }
            number=number>>1;
        }
        return result;
    }

    //  Time Complexity : O(Total number of set bits)
    public static int countSetsBrianKerningamAlgo(int number) {
        int result=0;
        while (number>0) {
            number = (number&(number-1));
            result++;
        }
        return result;
    }
}
