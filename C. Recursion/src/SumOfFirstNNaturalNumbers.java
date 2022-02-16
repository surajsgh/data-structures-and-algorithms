public class SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfFirstNNaturalNumbers(7));
    }

    public static int sumOfFirstNNaturalNumbers(int number) {
        if (number<=1) {
            return number;
        }
        return number + sumOfFirstNNaturalNumbers(number-1);
    }
}
