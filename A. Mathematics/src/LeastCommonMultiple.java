public class LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(LCM(3, 7));
    }

    public static int LCM(int number1, int number2) {
        int result = Math.max(number1, number2);
        while (true) {
            if ((result % number1 == 0) && (result % number2 == 0)) {
                break;
            }
            result++;
        }
        return result;
    }
}
