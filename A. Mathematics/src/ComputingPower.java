public class ComputingPower {
    public static void main(String[] args) {
        System.out.println(power(3, 4));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int power(int number, int times) {
        int result = 1;
        for (int i=1; i<=times; i++) {
            result = result * number;
        }
        return result;
    }
}
