import java.util.Arrays;

public class CheckForAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagramNaive("silent", "listan"));
        System.out.println(isAnagramEfficient("silent", "listen"));
    }

    //  Time Complexity : O(nlogn)
    public static boolean isAnagramNaive(String str1, String str2) {
        if (str1.length()!=str2.length()) {
            return false;
        }
        //  Conversion of string into character array.
        char a[] = str1.toCharArray();
        Arrays.sort(a);
        str1 = new String(a);

        char b[] = str2.toCharArray();
        Arrays.sort(b);
        str2 = new String(b);
        return str1.equals(str2);
    }

    //  Time Complexity : O(n);
    //  Auxiliary Space : O(1)
    static int character = 256;
    public static boolean isAnagramEfficient(String str1, String str2) {
        if (str1.length()!=str2.length()) {
            return false;
        }
        int[] count = new int[character];
        for (int i=0; i<str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i=0; i<character; i++) {
            if (count[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
