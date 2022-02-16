public class TwoPointerApproach {
    public static void main(String[] args) {
        twoPointerApproachNaive(new int[]{3, 5, 9, 2, 8, 10, 11}, 17);
        System.out.println(twoPointerApproachEfficient(new int[]{3, 5, 9, 2, 8, 10, 11}, 100));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
//    Always remember that you're supposed to use two pointer approach only if the array is sorted. Otherwise, you've to use hashing(If array is unsorted). 
    public static boolean twoPointerApproachEfficient(int arr[], int number) {
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            if (arr[left]+arr[right]==number) {
                return true;
            }
            else if (arr[left]+arr[right]>number) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void twoPointerApproachNaive(int arr[], int number) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum==number) {
                    System.out.println(arr[i] + ", " + arr[j]);
                }
            }
        }
    }
}
