public class LeftmostNonRepeatingElement {
    public static void main(String[] args) {
        System.out.println(find("GeeksForGeeks"));
        System.out.println(findGood("GeeksForGeeks"));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int find(String str) {
        for (int i=0; i<str.length(); i++) {
            boolean flag = true;
            for (int j=0; j<str.length(); j++) {
                if (i!=j && str.charAt(i)==str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    //  Two traversal of string
    static final int CHAR = 256;
    public static int findGood(String str) {
        int count[] = new int[CHAR];
        for (int i=0; i<str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i=0; i<str.length(); i++) {
            if (count[str.charAt(i)]==1) {
                return i;
            }
        }
        return -1;
    }
}
