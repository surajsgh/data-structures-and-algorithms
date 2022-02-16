//to count number of bits to be flipped to convert A to B.
public class CountBitFlip {
    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
    }

    public static int countBitsFlip(int a, int b){
        int count = 0;
        int result = a ^ b;
        while(result>0) {
            result = (result&(result-1));
            count++;
        }
        return count;
    }
}
