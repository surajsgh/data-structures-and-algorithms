import java.util.HashMap;

public class GenerateDocuments {
    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(number of distinct characters)
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        int m = characters.length();
        int n = document.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            map.put(characters.charAt(i), map.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for(int i=0; i<n; i++) {
            if(!map.containsKey(document.charAt(i)) || (map.get(document.charAt(i))==0)) return false;
            map.put(document.charAt(i), map.get(document.charAt(i))-1);
        }
        return true;
    }
}
