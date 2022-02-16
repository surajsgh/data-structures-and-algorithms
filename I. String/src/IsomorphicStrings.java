import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    //  Time Complexity = O(n*n)
    //  Auxiliary Space = O(n)
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char characterOfS = s.charAt(i);
            char characterOfT = t.charAt(i);
            if(map.containsKey(characterOfS)) {
                if(map.get(characterOfS).equals(characterOfT)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                //  Time Complexity for containsValue alone would be O(n)!
                if(!map.containsValue(characterOfT)) {
                    map.put(characterOfS, characterOfT);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
