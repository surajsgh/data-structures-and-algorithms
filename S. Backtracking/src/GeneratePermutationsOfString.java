public class GeneratePermutationsOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str.toCharArray(), 0, str.length()-1);
    }

    private static boolean isSafe(char[] characters, int low, int i, int high) {
        if (low!=0 && characters[low-1]=='A' && characters[i]=='B') return false;
        if (high==(low+1) && characters[i]=='A' && characters[low]=='B') return false;
        return true;
    }

    //  Naive Solution
    private static void permutation(char[] characters, int low, int high) {
        if (low==high) {
            System.out.println(String.valueOf(characters));
            return;
        }
        else {
            for (int i=low; i<=high; i++) {
                if (isSafe(characters, low, i, high)) {
                    char temp = characters[low];
                    characters[low] = characters[i];
                    characters[i] = temp;

                    permutation(characters, low+1, high);

                    temp = characters[low];
                    characters[low] = characters[i];
                    characters[i] = temp;
                }
            }
        }
    }
}
