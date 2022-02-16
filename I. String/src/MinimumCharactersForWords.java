import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWords {
    //  Time Complexity : O(Number of words * Length of longest word)
    //  Auxiliary Space : O(Number of unique characters)
    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        HashMap<Character, Integer> maxFrequencyCount = new HashMap<Character, Integer>();

        for(String word : words) {
            HashMap<Character, Integer> frequencyCount = countWordFrequency(word);
            updateMaxFrequencyCount(frequencyCount, maxFrequencyCount);
        }
        return resultList(maxFrequencyCount);
    }

    public HashMap<Character, Integer> countWordFrequency(String string) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c : string.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        return map;
    }

    public void updateMaxFrequencyCount(HashMap<Character, Integer> firstMap, HashMap<Character, Integer> secondMap) {
        for(Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            char character = entry.getKey();
            int integer = entry.getValue();

            if(secondMap.containsKey(character)) {
                secondMap.put(character, Math.max(integer, secondMap.get(character)));
            }
            else {
                secondMap.put(character, integer);
            }
        }
    }

    public char[] resultList(HashMap<Character, Integer> map) {
        List<Character> list = new ArrayList<>();

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            for(int i=0; i<entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }

        char[] resultCharacters = new char[list.size()];
        for(int i=0; i<resultCharacters.length; i++) {
            resultCharacters[i] = list.get(i);
        }
        return resultCharacters;
    }
}
