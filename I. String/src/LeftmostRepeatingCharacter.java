public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
//        System.out.println(findLeftmostRepeatingCharacter("cabbad"));
        System.out.println(findLeftmostRepeatingCharacterGood("geeksforgeeks"));
        System.out.println(findLeftmostRepeatingCharacterEfficient("geeksforgeeks"));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int findLeftmostRepeatingCharacter(String str) {
        for (int i=0; i<str.length(); i++) {
            for (int j=i+1; j<str.length(); j++) {
                if (str.charAt(i)==str.charAt(j)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    //  Two traversal of array.
    static final int CHAR = 256;
    public static int findLeftmostRepeatingCharacterGood(String str) {
        int[] count = new int[CHAR];
        for (int i=0; i<str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i=0; i<str.length(); i++) {
            if (count[str.charAt(i)]>1) {
                return i;
            }
        }
        return -1;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    //  One traversal of array.
    public static int findLeftmostRepeatingCharacterEfficient(String str) {
        int res = -1;
        boolean[] visited = new boolean[CHAR];
        for (int i=str.length()-1; i>=0; i--) {
            if(visited[str.charAt(i)]) {
                res = i;
            }
            else {
                visited[str.charAt(i)] = true;
            }
        }
        return res;
    }
}
