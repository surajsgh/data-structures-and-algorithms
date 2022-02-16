import java.util.ArrayList;
import java.util.List;

public class NthRowOfThePascalsTriangle {
    public static void main(String[] args) {
        System.out.println(nthRow(3));
    }

    //  Time Complexity : O(k*k)
    //  Auxiliary Space : O(k)
    public static List<Integer> nthRow(int k) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=k; i++) {
            list.add(1);
            for (int j=i-1; j>0; j--) {
                list.set(j, list.get(j) + list.get(j-1));
            }
        }
        return list;
    }
}
