public class FrequencyOfAlimitedRangeArrayElements {
//    Time Complexity : O(n);
//    Space Complexity : O(1)
    public static void frequencycount(int arr[], int n)
    {
        for (int i=0; i<arr.length; i++) {
            arr[i]--;
        }

        for (int j=0; j<arr.length; j++) {
            arr[arr[j]%n] += n;
        }

        for (int k=0; k<n; k++) {
            System.out.print(arr[k]/n + " ");
        }
    }
}
