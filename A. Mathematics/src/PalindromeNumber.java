// A program to check whether the given number is palindrome or not.
public class PalindromeNumber {
    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int temp = number;

        while (temp!=0) {
            int remainder = temp % 10;
            reverse = reverse*10 + remainder;
            temp = temp / 10;
        }

        return (reverse == number);
    }

    public static void main(String[] args) {
        int no = 12320;
        System.out.println(isPalindrome(no));
    }
}
