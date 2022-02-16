import java.util.HashSet;
import java.util.Iterator;

// HashSet data structure is used to store keys only.
public class HashSetOperations {
    public static void main(String[] args) {
        HashSet<String> keywords = new HashSet<String>();
        //  Phase 1 operation
        //  Add operation on hashset
        keywords.add("Suraj");
        keywords.add("Salman");
        keywords.add("Ganesh");
        System.out.println(keywords);

        //  Contains operation on hashset
        System.out.println(keywords.contains("Suraj"));
        System.out.println(keywords.contains("Ronaldo"));

        //  Iterators on hashset
        Iterator<String> iterator = keywords.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        //  size operation on hashset
        System.out.println("The size of hashset data structure is : " + keywords.size());

        //  remove operation on hashset
        keywords.remove("Ganesh");
        System.out.println("The size of hashset data structure is : " + keywords.size());
        for (String s : keywords) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        //  isEmpty operation
        System.out.println(keywords.isEmpty());
    }
}
