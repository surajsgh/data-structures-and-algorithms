import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(longestDistinct("abca"));
        System.out.println(longestDistinctGood("bbcsbd"));
        System.out.println(longestDistinctEfficient("abca"));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(min(n, a))
    public static int longestSubstringWithoutDuplication(String str) {
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
        return result.length();
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        int n = s.length();

        Set<Character> set = new HashSet<Character>();

        while(end < n) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return max;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int CHAR = 256;
    public static int longestDistinctEfficient(String str) {
        int n = str.length();
        int res = 0;
        int[] count = new int[CHAR];
        Arrays.fill(count, -1);
        int i = 0;
        for (int j = 0; j<n; j++) {
            i = Math.max(i, count[str.charAt(j)]+1);
            res = Math.max(res, j-i+1);
            count[str.charAt(j)] = j;
        }
        return res;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int longestDistinctGood(String str) {
        int n = str.length();
        int res = 0;
        for (int i=0; i<n; i++) {
            boolean[] count = new boolean[256];
            for (int j=i; j<n; j++) {
                if (count[str.charAt(j)]) {
                    break;
                }
                else {
                    res = Math.max(res, j-i+1);
                    count[str.charAt(j)] = true;
                }
            }
        }
        return res;
    }

    //  Time Complexity : O(n*n*n)
    //  Auxiliary Space : O(1)
    public static int longestDistinct(String str) {
        int n = str.length();
        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (areDistinct(str, i, j)) {
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }

    public static boolean areDistinct(String str, int i, int j) {
        boolean visited[] = new boolean[256];
        for (int k=i; k<=j; k++) {
            if (visited[str.charAt(k)]) {
                return false;
            }
            visited[str.charAt(k)] = true;
        }
        return true;
    }
}
