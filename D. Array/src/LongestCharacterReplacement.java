public class LongestCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        System.out.println(characterReplacement(str, 1));
    }

    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 1;
        for (int i=0; i<26; i++) {
            maxLength = Math.max(maxLength, findLength(s, n, k, (char)(i + 'A')));
            // maxLength = Math.max(maxLength, findLength(s, n, k, (char)(i + 'a')));
        }
        return maxLength;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int findLength(String s, int n, int k, char ch) {
        int maxLength = 1;
        int count = 0;
        int left = 0;
        int right = 0;

        while(right < n) {
            if(s.charAt(right)!=ch) {
                count++;
            }

            while(count>k) {
                if(s.charAt(left)!=ch) {
                    count--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
