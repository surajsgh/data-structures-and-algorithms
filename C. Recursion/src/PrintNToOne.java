// A program to print the numbers from N to one.
public class PrintNToOne {
    public static void main(String[] args) {
        printNToOne(5);
    }

    public static void printNToOne(int number) {
        if (number==0) {
            return;
        }
        System.out.println(number);
        printNToOne(number-1);
    }
}
