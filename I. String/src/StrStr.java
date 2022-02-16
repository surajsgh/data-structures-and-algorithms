public class StrStr {
    public static void main(String[] args) {
        System.out.println(find("geeksforgeeks", "for"));
        System.out.println(findEfficient("geeksforgeeks", "for"));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 || haystack.equals(needle)) return 0;
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            String evalString = haystack.substring(i, i+needle.length());
            if(evalString.equals(needle)) return i;
        }
        return -1;
    }

    //  Time Complexity : O(m*n)
    //  Auxiliary Space : O(1)
    public static int find(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        for (int i=0; i<=m-n; i++) {
            int j;
            for (j=0; j<n; j++) {
                if (str1.charAt(i+j)!=str2.charAt(j)) {
                    break;
                }
            }
            if (j==n) {
                return i;
            }
        }
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int findEfficient(String str1, String str2) {
        int pointer = 0;
        int i;
        for (i=0; i<str1.length(); i++) {
            if (pointer==str2.length()) {
                break;
            }
            if (str1.charAt(i)==str2.charAt(pointer)) {
                pointer++;
            }
            else {
                pointer = 0;
            }
        }
        return pointer < str2.length() ? -1 : i-pointer;
    }
}
