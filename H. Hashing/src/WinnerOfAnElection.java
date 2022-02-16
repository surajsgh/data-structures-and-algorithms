import java.util.HashMap;
import java.util.Map;

public class WinnerOfAnElection {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static String[] findWinner(String[] arr, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int winnerCount = 0;
        String winnerString = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (winnerCount < value) {
                winnerCount = value;
                winnerString = key;
            }
            else if (winnerCount==value && winnerString.compareTo(key)>0) {
                winnerString = key;
            }
        }
        String[] str = {winnerString,  winnerCount+ " "};
        return str;
    }
}
