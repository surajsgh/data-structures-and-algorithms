public class WaveArray {
    public static void convertToWave(int arr[]){
//         This method only works if the given array is sorted. You can still follow this approach even if the given array is not sorted. All you have to do is, sort the array and
//         then follow this approach.(Time Complexity for this approach would be O(nlog(n))).
//         Time Complexity : O(n)
//         Auxiliary Space : O(1)
        for (int i=0; i<arr.length-1; i+=2) {
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }
    
//     Time Complexity : O(n)
//     Auxiliary Space : O(1)
    public static void convertToWaveEfficient(int arr[]) {
        for(int i=0; i<arr.length; i+=2) {
            if(i>0 && arr[i] < arr[i-1]) {
                swap(arr[i], arr[i-1]);
            }
            if(i<arr.length-1 && arr[i] < arr[i+1]) {
                swap(arr[i], arr[i+1]);
            }
        }
    }
    
    public static void swap(int number1, int number2) {
        int temp = number1;
        number1 = number2;
        number2 = temp;
    }
}
