// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
class SortArrayByParity2 {
//  Time Complexity : O(n)
//  Auxiliary Space : O(1)
    public int[] sort(int nums[]) {
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) {
            if (nums[i]%2 == 1) {
                while (nums[j]%2 == 1) {
                    j += 2;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
