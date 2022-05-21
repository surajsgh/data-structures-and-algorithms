public class ProductArrayResult {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int[] productExceptSelfEff(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0, temp=1; i<n; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        for(int i=n-1, temp=1; i>=0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int[] productExceptSelfNaive(int[] nums) {
        int n = nums.length;

        int[] leftArray = new int[n];
        int[] rightArray = new int[n];
        int[] result = new int[n];

        leftArray[0] = 1;
        rightArray[n-1] = 1;

        for(int i=1; i<n; i++) {
            leftArray[i] = leftArray[i-1]*nums[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            rightArray[i] = rightArray[i+1]*nums[i+1];
        }

        for(int i=0; i<n; i++) {
            result[i] = leftArray[i] * rightArray[i];
        }

        return result;
    }
}
