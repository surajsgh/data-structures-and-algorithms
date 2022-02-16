import java.util.ArrayList;
import java.util.List;

public class DisappearedValuesInAnArray {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums) {
            i = Math.abs(i);
            if(nums[i-1]>0) {
                nums[i-1] *= -1;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i]>0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
