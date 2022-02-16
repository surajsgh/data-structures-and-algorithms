import java.util.ArrayList;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }

    //  Time Complexity : O(2**n)
    //  Auxiliary Space : O(1)
    public static ArrayList<String> grayCode(int n) {
        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        int i, j;
        for (i=2; i<(1<<n); i<<=1) {
            for (j=i-1; j>=0; j--) {
                list.add(list.get(j));
            }
            for (j=0; j<i; j++) {
                list.set(j, "0"+list.get(j));
            }
            for (j=i; j<2*i; j++) {
                list.set(j, "1"+list.get(j));
            }
        }
        return list;
    }
}
