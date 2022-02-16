import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {
    public static void main(String[] args) {
        //  Creation of HashMap
        HashMap<String, Integer> keyValue = new HashMap<>();

        //  Add elements to the HashMap keyValue(Put operation)
        keyValue.put("NASA", 1);
        keyValue.put("ISRO", 2);
        keyValue.put("SpaceX", 3);

        //  Output and Size of the HashMap
        System.out.println(keyValue);
        System.out.println(keyValue.size());

        //  Iterating over HashMap
        for (Map.Entry<String, Integer> e : keyValue.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        //  containsKey operation
        if (keyValue.containsKey("NASA")) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        //  Remove operation
        keyValue.remove("NASA");
        System.out.println(keyValue.size());

        //  containsValue operation
        if (keyValue.containsValue(2)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        //  Get operation
        System.out.println(keyValue.get("TESLA"));
    }
}
