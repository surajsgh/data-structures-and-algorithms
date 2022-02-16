import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ReorganizeString {
    /*
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Queue<Character> queue = new PriorityQueue<Character>((a, b) -> map.get(b)-map.get(a));
        queue.addAll(map.keySet());

        StringBuilder str = new StringBuilder();
        while(queue.size()>1) {
            char first = queue.poll();
            char second = queue.poll();
            str.append(first);
            str.append(second);
            map.put(first, map.get(first)-1);
            map.put(second, map.get(second)-1);
            if(map.get(first)>0) {
                queue.add(first);
            }
            if(map.get(second)>0) {
                queue.add(second);
            }
        }

        if(!queue.isEmpty()) {
            if(map.get(queue.peek())>1) {
                return "";
            }
            else {
                str.append(queue.peek());
            }
        }

        return str.toString();
    }
    */

}
