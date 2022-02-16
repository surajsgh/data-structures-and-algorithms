public class OneToN {
    public static void main(String[] args) {
        printOneToN(5);
    }

    public static void printOneToN(int number) {
        if (number==0) {
            return;
        }
        printOneToN(number-1);
        System.out.println(number);
    }
}
