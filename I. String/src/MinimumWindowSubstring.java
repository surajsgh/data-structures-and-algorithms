import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // Time Complexity : O(m+n)
    // Auxiliary Space : O(m)
    public String minWindow(String s, String t) {
        if(s.length()==0 || s==null || t.length()==0 || t==null) return "";

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int start = 0;
        int matchedElement = 0;
        int minSubStringLength = Integer.MAX_VALUE;
        int minSubStringStart = 0;
        for(int end = 0; end<s.length(); end++) {
            char stringChar = s.charAt(end);

            if(map.containsKey(stringChar)) {
                map.put(stringChar, map.get(stringChar)-1);

                if(map.get(stringChar)>=0) matchedElement++;
            }

            while(matchedElement==t.length()) {
                if(end-start+1 < minSubStringLength) {
                    minSubStringLength = end-start+1;
                    minSubStringStart = start;
                }

                char charAtStart = s.charAt(start++);

                if(map.containsKey(charAtStart)) {
                    if(map.get(charAtStart)==0) {
                        matchedElement--;
                    }
                    map.put(charAtStart, map.get(charAtStart) + 1);
                }
            }
        }

        if(minSubStringLength > s.length()) return "";

        return s.substring(minSubStringStart, minSubStringStart + minSubStringLength);
    }
}
