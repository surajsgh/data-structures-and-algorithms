//a lucky integer is an integer which has a frequency in the array equal to its value.
public class LuckyIntegersInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3};
        System.out.print(findLucky(nums));
    }

    //  Time Complexity : O(n);
    //  Auxiliary Space : O(1);
    public static int findLucky(int[] nums) {
        int[] arr = new int[501];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i=500; i>=0; i--) {
            if (arr[i]==i) {
                return i;
            }
        }
        return -1;
    }
}
