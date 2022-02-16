public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(getMedian(new int[]{10, 20, 30, 40, 50}, new int[]{5, 15, 25, 35, 45}));
    }

//    This approach is only possible for two arrays with different sizes.
//    Time Complexity : O(log(n1))
//    Auxiliary Space : O(1)
    public static double getMedian(int array1[], int array2[]) {
        int n1 = array1.length;
        int n2 = array2.length;
        int begin1 = 0;
        int end1 = n1;
        while (begin1 < end1) {
            int i1 = (begin1 + end1)/2;
            int i2 = (n1 + n2 + 1)/2 - i1;
            int min1 = (i1 == n1)?Integer.MAX_VALUE:array1[i1];
            int max1 = (i1 == 0)?Integer.MIN_VALUE:array1[i1-1];
            int min2 = (i2 == n2)?Integer.MAX_VALUE:array2[i2];
            int max2 = (i2 == 0)?Integer.MIN_VALUE:array2[i2-1];
            if (max1<=min2 && max2<=min1) {
                if ((n1 + n2)%2 == 0) {
                    return ((double) Math.max(max1, max2) + Math.min(min1, min2))/2;
                }
                else {
                    return (double) Math.max(max1, max2);
                }
            }
            else if (max1 > min2) {
                end1 = i1 - 1;
            }
            else {
                 begin1 = i1 + 1;
            }
        }
        return -1;
    }

//    This approach is applicable in every possible situation.
//    Time Complexity : O(log(min(m,n)))
//    Auxiliary Space : O(1)
    public static double findMedianEfficient(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if(m>n) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
            int temp1 = m;
            m = n;
            n = temp1;
        }
        int begin = 0;
        int end = m;
        while (begin<=end) {
            int i = (begin + end)/2;
            int j = ((m+n+1)/2)-i;
            if(i>begin && arr1[i-1]>arr2[j]) {
                end = i - 1;
            }
            else if (i<end && arr1[i]<arr2[j-1]) {
                begin = i + 1;
            }
            else {
                int maxLeft = 0;
                if (i==0) {
                    maxLeft = arr2[j-1];
                }
                else if (j==0) {
                    maxLeft = arr1[i-1];
                }
                else {
                    maxLeft = Math.max(arr1[i-1], arr2[j-1]);
                }
                if ((m+n)%2==1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i==m) {
                    minRight = arr2[j];
                }
                else if (j==n) {
                    minRight = arr1[j];
                }
                else {
                    minRight = Math.min(arr1[j], arr2[j]);
                }
                if ((m+n)%2==0) {
                    return (maxLeft+minRight)/2;
                }
            }
        }
        return 0.0;
    }
}
