public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abc", 0, 2));
    }

    public static boolean isPalindrome(String inputString, int start, int end) {
        if (start>=end) {
            return true;
        }
        return (inputString.charAt(start)==inputString.charAt(end)) && isPalindrome(inputString, start+1, end-1);
    }
}
