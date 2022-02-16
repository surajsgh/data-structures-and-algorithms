import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    int CHAR = 26;

    //  Time Complexity : O(size of s + size of p)
    //  Auxiliary Space : O(1)
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()==0 || p.length()>s.length()) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int[] charArray = new int[CHAR];
        for(char ch : p.toCharArray()) {
            charArray[ch-'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while(right<s.length()) {
            if(charArray[s.charAt(right++)-'a']-- >= 1) count--;

            if(count==0) list.add(left);

            if(right-left==p.length() && charArray[s.charAt(left++)-'a']++ >= 0) count++;
        }

        return list;
    }
}
