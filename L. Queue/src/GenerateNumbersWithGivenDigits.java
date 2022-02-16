import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        printFirstN(10);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static void printFirstN(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("5");
        queue.offer("6");

        for (int i=0; i<n; i++) {
            String str = queue.poll();
            System.out.println(str);
            queue.offer(str + "5");
            queue.offer(str + "6");
        }
    }

    /*
    Another variation to add binary numbers upto N
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for(int i=0; i<N; i++) {
            String str = queue.poll();
            list.add(str);
            queue.offer(str + "0");
            queue.offer(str + "1");
        }

        return list;
    }
    */
}
