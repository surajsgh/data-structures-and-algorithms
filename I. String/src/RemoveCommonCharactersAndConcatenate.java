import java.util.HashMap;
import java.util.Map;

public class RemoveCommonCharactersAndConcatenate {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(number of distinct characters)
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        String res = " ";

        int m = s1.length();
        int n = s2.length();

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(s2.charAt(i), 1);
        }

        for(int i=0; i<m; i++) {
            if(!map.containsKey(s1.charAt(i))) {
                res += s1.charAt(i);
            }
            else {
                map.put(s1.charAt(i), 2);
            }
        }

        for(int i=0; i<n; i++) {
            if(map.get(s2.charAt(i))==1) {
                res += s2.charAt(i);
            }
        }

        return res;
    }
}
