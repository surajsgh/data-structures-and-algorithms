import java.util.HashMap;

public class LongestSubstringWithoutDuplication {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(min(n, a))
    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int[] longest = {0, 1};
        int startIndex = 0;

        for(int i=0; i<n; i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                startIndex = Math.max(startIndex, map.get(c)+1);
            }
            if(longest[1]-longest[0]<i+1-startIndex) {
                longest = new int[]{startIndex, i+1};
            }
            map.put(c, i);
        }

        String result = str.substring(longest[0], longest[1]);
        return result;
    }
}
