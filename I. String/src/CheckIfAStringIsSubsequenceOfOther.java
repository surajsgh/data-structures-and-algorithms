public class CheckIfAStringIsSubsequenceOfOther {
    public static void main(String[] args) {
        System.out.println(checkIterative("ABCDEF", "ADB"));
        String str1 = "ABCDEF";
        String str2 = "ABEF";
        System.out.println(checkRecursive(str1, str2, str1.length(), str2.length()));
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(1)
    public static boolean checkIterative(String str1, String str2) {
        if (str1.length()<str2.length()) {
            return false;
        }
        int j=0;
        for (int i=0; i<str1.length() && j<str2.length(); i++) {
            if (str1.charAt(i)==str2.charAt(j)) {
                j++;
            }
        }
        return (j==str2.length());
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(m+n)
    public static boolean checkRecursive(String str1, String str2, int m, int n) {
        if(n==0) {
            return true;
        }
        if(m==0){
            return false;
        }
        if (str1.charAt(m-1)==str2.charAt(n-1)) {
            return checkRecursive(str1, str2, m-1, n-1);
        }
        else {
            return checkRecursive(str1, str2, m-1, n);
        }
    }
}
