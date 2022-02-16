import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> numberList = new ArrayList<>();
            for(int j=0; j<i+1; j++) {
                if(j==0 || j==i) {
                    numberList.add(1);
                }
                else {
                    numberList.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(numberList);
        }
        return list;
    }
}
