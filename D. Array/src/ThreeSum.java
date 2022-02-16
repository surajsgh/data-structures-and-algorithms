import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(find(nums));
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static List<List<Integer>> find(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int low = i+1;
            int high = n-1;
            int target = -nums[i];
            while(low<high) {
                int sum = nums[low] + nums[high];
                if(sum==target) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while(low<high && nums[low]==nums[low-1]) low++;
                    while(low<high && nums[high]==nums[high+1]) high--;
                }
                else if(sum<target) {
                    low++;
                }
                else {
                    high--;
                }
            }
        }
        return list;
    }
}
