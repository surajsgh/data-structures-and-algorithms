public class RemoveElements {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int num : nums) {
            if(num==val) continue;
            nums[i++] = num;
        }
        return i;
    }
}
