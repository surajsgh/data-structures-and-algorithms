public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        System.out.println(maxArearNaive(height));
        System.out.println(maxAreaAlt(height));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int maxAreaAlt(int[] height) {
        int n = height.length;
        int max = 0;
        int low = 0;
        int high = height.length-1;
        while (low<high) {
            max = Math.max(Math.min(height[low], height[high])*(high-low), max);
            if (height[low]<height[high]) {
                low++;
            }
            else {
                high--;
            }
        }
        return max;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static int maxArearNaive(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                max = Math.max(Math.min(height[i], height[j])*(j-i), max);
            }
        }
        return max;
    }

//    Time Complexity : O(n);
//    Auxiliary Space : O(1);
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        int gap = height.length-1;
        while(left<right) {
            if(height[left]<=height[right]) {
                max = Math.max(height[left]*gap, max);
                left++;
                gap--;
            }
            else {
                max = Math.max(height[right]*gap, max);
                right--;
                gap--;
            }
        }
        return max;
    }
}
