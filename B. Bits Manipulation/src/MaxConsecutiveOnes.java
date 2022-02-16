public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(14));
    }

    public static int maxConsecutiveOnes(int x) {
        if(x==0) {
            return 0;
        }

        int count = 0;

        while(x>0) {
            x = (x&(x<<1));
            count++;
        }

        return count;
    }
}
