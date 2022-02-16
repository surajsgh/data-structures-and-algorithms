import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        //  TreeSet
        TreeSet<String> stringSet = new TreeSet<>();

        //  Add operation
        stringSet.add("geeks");
        stringSet.add("for");
        stringSet.add("students");

        //  Print the stringSets
        System.out.println(stringSet);

        //  Boolean operation
        System.out.println(stringSet.contains("geeks"));

        //  Iteration
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //  TreeSet for integers
        TreeSet<Integer> integerSet = new TreeSet<>();

        //  Add operation
        integerSet.add(2);
        integerSet.add(4);
        integerSet.add(1);
        integerSet.add(6);

        //  Print
        System.out.println(integerSet);

        //  Remove operation
        integerSet.remove(4);

        //  Iteration
        Iterator<Integer> iteratorInteger = integerSet.iterator();
        while (iteratorInteger.hasNext()) {
            System.out.print(iteratorInteger.next() + " ");
        }

        //  Methods
        //  Largest values lower than 5
        System.out.println("method values:");
        System.out.println(integerSet.lower(5));

        //  Smallest values higher than 5
        System.out.println(integerSet.higher(5));

        //  Values <=5
        System.out.println(integerSet.floor(5));

        //  Values >=5
        System.out.println(integerSet.ceiling(5));
    }
}
