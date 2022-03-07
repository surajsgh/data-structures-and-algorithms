public class GeneratePermutationsOfString {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str.toCharArray(), 0, str.length());
    }

    //  Naive Solution
    private static void permutation(char[] characters, int low, int right) {
        if (low==right) {
            if (!String.valueOf(characters).contains("AB")) {
                System.out.println(String.valueOf(characters));
            }
            return;
        }

        for (int i=low; i<right; i++) {
            char temp = characters[low];
            characters[low] = characters[i];
            characters[i] = temp;

            permutation(characters, low+1, right);

            temp = characters[low];
            characters[low] = characters[i];
            characters[i] = temp;
        }
    }
}
