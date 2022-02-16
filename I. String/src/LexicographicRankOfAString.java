public class LexicographicRankOfAString {
    public static void main(String[] args) {
        System.out.println(lexRank("STRING"));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    static final int CHAR = 256;
    public static int lexRank(String str) {
        int res = 1;
        int num = str.length();
        int multiplication = fact(num);
        int[] count = new int[CHAR];
        for (int i=0; i<num; i++) {
            count[str.charAt(i)]++;
        }
        for (int i=1; i<CHAR; i++) {
            count[i] += count[i-1];
        }
        for (int i=0; i<num-1; i++) {
            multiplication = multiplication/(num-i);
            res += count[str.charAt(i)-1]*multiplication;
            for (int j=str.charAt(i); j<CHAR; j++) {
                count[j]--;
            }
        }
        return res;
    }

    public static int fact(int number) {
        return (number <= 1)?1:number*fact(number-1);
    }
}
