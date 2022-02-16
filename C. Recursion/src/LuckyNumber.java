public class LuckyNumber {
    static int counter=2;
    public static void main(String[] args) {
        System.out.println(isLucky(19));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static boolean isLucky(int n) {
        if(n<counter) {
            return true;
        }
        else if(n%counter==0) {
            return false;
        }

        n=n-n/counter;
        counter++;
        return isLucky(n);
    }
}
