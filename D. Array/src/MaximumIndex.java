public class MaximumIndex {

//    Time Complexity : O(n)
//    Auxiliary Space : O(n)
    // arr[]: input array
    // n: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int arr[], int n) {
        int maxDiff = -1;

        int LArray[] = new int[n];
        int RArray[] = new int[n];

        LArray[0] = arr[0];
        for(int i=1; i<n; i++) {
            LArray[i] = Math.min(LArray[i-1], arr[i]);
        }

        RArray[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            RArray[i] = Math.max(RArray[i+1], arr[i]);
        }

        int i=0;
        int j=0;
        while(i<n && j<n) {
            if(LArray[i] <= RArray[j]) {
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }
            else {
                i++;
            }
        }
        return maxDiff;
    }
}
