public class AllocateMinimumNumberOfPages {
    public static boolean isFeasible(int arr[], int k, int currMin) {
        int n = arr.length;
        int studentsRequired = 1;
        int currSum = 0;

        for (int i=0; i<n; i++) {
            if (currMin<arr[i]) {
                return false;
            }

            if (currSum + arr[i]>currMin) {
                studentsRequired++;
                currSum = arr[i];
                if (studentsRequired>k) {
                    return false;
                }
            }
            else {
                currSum += arr[i];
            }
        }
        return true;
    }

//  Time Complexity : O(nlog(sum))
//  Auxiliary Space : O(1)
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        long sum = 0;
        if (n<k) {
            return -1;
        }

        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        int start = 0;
        int end = (int) sum;
        int result = Integer.MAX_VALUE;

        while (start<=end) {
            int mid = (start+end)/2;
            if (isFeasible(arr, k, mid)) {
                result = Math.min(result, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return result;
    }
}
