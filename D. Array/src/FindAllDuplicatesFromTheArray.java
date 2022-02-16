import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesFromTheArray {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            int n = Math.abs(nums[i]);
            if(nums[n-1]<0) {
                list.add(n);
            }
            else {
                nums[n-1] = -nums[n-1];
            }
        }
        return list;
    }
}
