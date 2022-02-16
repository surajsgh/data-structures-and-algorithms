public class AnagramSearch {
    public static void main(String[] args) {
        System.out.println(isAnagram("geeksforgeeks", "frop"));
    }

    static final int CHAR = 256;
    public static boolean areSame(int[] CT, int[] CP) {
        for (int i=0; i<CHAR; i++) {
            if (CP[i]!=CT[i]) {
                return false;
            }
        }
        return true;
    }

    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(1)
    public static boolean isAnagram(String txt, String pat) {
        int[] CT = new int[CHAR];
        int[] CP = new int[CHAR];
        for (int i=0; i<pat.length(); i++) {
            CT[txt.charAt(i)]++;
            CP[pat.charAt(i)]++;
        }
        for (int j=pat.length(); j<txt.length(); j++) {
            if (areSame(CT, CP)) {
                return true;
            }
            CT[txt.charAt(j)]++;
            CT[txt.charAt(j-pat.length())]--;
        }
        return false;
    }
}
