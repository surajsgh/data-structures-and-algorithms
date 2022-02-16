public class LongestSubstringPalindrome {
    //  Time Complexity : O(n*n*n)
    //  Auxiliary Space : O(n)
    public static String longestPalindromicSubstringNaive(String str) {
        // Write your code here.
        int n = str.length();
        String result = "";

        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String subString = str.substring(i, j+1);
                if(subString.length() > result.length() && checkPalindromeNaive(subString)) {
                    result = subString;
                }
            }
        }
        return result;
    }

    public static boolean checkPalindromeNaive(String str) {
        int start = 0;
        int end = str.length()-1;
        while(start<end) {
            if(str.charAt(start)!=str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(n)
    public static String longestPalindromicSubstringEfficient(String str) {
        // Write your code here.
        int n = str.length();
        int[] currentLongest = {0, 1};
        for(int i=1; i<n; i++) {
            int[] odd = range(str, i-1, i+1);
            int[] even = range(str, i-1, i);
            int[] longest = odd[1]-odd[0] > even[1]-even[0] ? odd : even;
            currentLongest = currentLongest[1]-currentLongest[0] > longest[1]-longest[0] ? currentLongest : longest;
        }
        return str.substring(currentLongest[0], currentLongest[1]);
    }

    public static int[] range(String str, int start, int end) {
        while(start>=0 && end<str.length()) {
            if(str.charAt(start)!=str.charAt(end)) break;
            start--;
            end++;
        }
        return new int[]{start+1, end};
    }
}
