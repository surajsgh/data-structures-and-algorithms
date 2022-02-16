// Write a program for trapping rain water problem.
public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        System.out.println(findWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //  Efficient Solution
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int findWater(int arr[]) {
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;

        int initial = 0;
        int last = arr.length - 1;

        while (initial <= last) {
            if (arr[initial] < arr[last]) {
                if (leftMax < arr[initial]) {
                    leftMax = arr[initial];
                }
                else {
                    result += leftMax - arr[initial];
                }
                initial++;
            }
            else {
                if (rightMax < arr[last]) {
                    rightMax = arr[last];
                }
                else {
                    result += rightMax - arr[last];
                }
                last--;
            }
        }
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int result = 0;

        left[0] = height[0];
        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        for(int i=0; i<n; i++) {
            result += Math.min(left[i], right[i])-height[i];
        }

        return result;
    }
}
