public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome("naman"));
    }

    //  Auxiliary Space = O(n)
    //  Time Complexity = O(n)
    public static boolean isPalindrome(String str) {
        StringBuilder rev = new StringBuilder(str);
        rev.reverse();
        return str.equals(rev.toString());
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static boolean isPalindromeEfficient(String str) {
        int begin = 0;
        int end = str.length()-1;
        while (begin<end) {
            if (str.charAt(begin)!=str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    /*
    For "A man, a plan, a canal: Panama" input
    int start = 0;
        int end = s.length()-1;
        while(start<end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    */
}
