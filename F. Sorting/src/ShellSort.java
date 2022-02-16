public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        shellSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap=n/2; gap>=1; gap/=2) {
            for (int i=gap; i<n; i++) {
                for (int j=i-gap; j>=0; j-=gap) {
                    if (arr[j+gap]<arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
}
