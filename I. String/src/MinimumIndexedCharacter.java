import java.util.HashSet;

public class MinimumIndexedCharacter {
    public static void main(String[] args) {
        System.out.println(findMinIndexedCharacter("onkl", "adcffaet"));
        System.out.println(findMinIndexedCharacterEfficient("geeksforgeeks", "set"));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int findMinIndexedCharacter(String str1, String str2) {
        int minIndex = Integer.MAX_VALUE;
        for (int i=0; i<str1.length(); i++) {
            for (int j=0; j<str2.length(); j++) {
                if (str1.charAt(i)==str2.charAt(j) && j<minIndex) {
                    minIndex = j;
                    break;
                }
            }
        }
        if (minIndex!=Integer.MAX_VALUE) {
            return minIndex;
        }
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int findMinIndexedCharacterEfficient(String str, String pat) {
        int i;
        int nStr = str.length();
        int nPat = pat.length();
        HashSet<Character> set = new HashSet<>();
        for (i=0; i<nPat; i++) {
            set.add(pat.charAt(i));
        }
        for (i=0; i<nStr; i++) {
            if (set.contains(str.charAt(i))) {
                break;
            }
        }
        if (i<nStr) {
            return i;
        }
        else {
            return -1;
        }
    }
}
