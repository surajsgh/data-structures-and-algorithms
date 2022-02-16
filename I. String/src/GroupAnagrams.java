import java.util.*;

public class GroupAnagrams {
    //  Time Complexity : O(nmlogm)
    //  Auxiliary Space : O(mn)
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
//            We can replace the above two lines with the given below lines of code for optimized approach.
//            char[] ca = new char[26];
//            for (char c : s.toCharArray()) ca[c - 'a']++;
//            String keyStr = String.valueOf(ca);
            String strKey = new String(charArray);
            if(!map.containsKey(strKey)) map.put(strKey, new ArrayList<>());
            map.get(strKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
