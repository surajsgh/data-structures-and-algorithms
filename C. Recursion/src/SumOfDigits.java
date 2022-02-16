public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(getSum(2));
    }

    public static int getSum(int number) {
        if (number<=9) {
            return number;
        }
        else {
            return getSum(number/10) + number%10;
        }
    }
}
