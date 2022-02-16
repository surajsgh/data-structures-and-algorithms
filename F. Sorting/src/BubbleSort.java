import java.util.Arrays;

// Bubble sort algo runs in the form of different phases. First phase transfers the maximum element to the last position, second max element gets transferre-
// d to the second last element and so on.
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {2, 8, 7, 12, 10};
        bubbleSort(arr);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static void bubbleSort(int arr[]) {
        int temp = 0;
        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}
