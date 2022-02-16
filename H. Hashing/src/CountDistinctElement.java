import java.util.HashSet;

public class CountDistinctElement {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30};
        System.out.println(count(arr, arr.length));
        System.out.println(countEfficient(arr, arr.length));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int count(int[] arr, int n) {
        int count = 0;
        for (int i=0; i<n; i++) {
            boolean flag = false;
            for (int j=0; j<i; j++) {
                if (arr[i]==arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }
        return count;
    }
    
    //  You can solve this problem by sorting the whole array and then comparing it with their adjacent element and increment the count if both the adjacent elements differs.
    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(1)

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static int countEfficient(int[] arr, int count) {
        HashSet<Integer> keys = new HashSet<>();
        for (int i: arr) {
            keys.add(i);
        }
        return keys.size();
    }
}
