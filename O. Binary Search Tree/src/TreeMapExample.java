import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        //  TreeMap
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        //  Add key-value pairs
        map.put(10, "Geeks");
        map.put(20, "For");
        map.put(30, "Students");
        System.out.println(map);

        //  Checks whether the map contains the key
        System.out.println(map.containsKey(20));

        //  Looping over the TreeMap
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //  Useful methods
        System.out.println(map.lowerEntry(20));
        System.out.println(map.higherEntry(20));
        System.out.println(map.ceilingEntry(21));
        System.out.println(map.floorEntry(29));
    }
}
