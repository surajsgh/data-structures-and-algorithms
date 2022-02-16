// Find the second largest element in an array.
public class SecondLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(secondLargestElementInAnArrayNaive(new int[]{5, 8, 18, 21, 16}));
        System.out.println(findSecondLargestElementInAnArrayEfficient(new int[]{3, 19, 11, 12}));
    }

//    However, there are two for loops in this method.
//     Time Complexity : O(n)
//     Space Complexity : O(1)
    public static int secondLargestElementInAnArrayNaive(int arr[]) {
        int largest = findLargest(arr);
        int result = -1;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]!=arr[largest]) {
                if (result==-1) {
                    result = i;
                }
                else if (arr[result]<arr[i]) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static int findLargest(int arr[]) {
        int result = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>arr[result]) {
                result = i;
            }
        }
        return result;
    }

//    There's only one for loop in this method. Thus, it's an efficient solution.
//     Time Complexity : O(n)
//     Space Complexity : O(1)
    public static int findSecondLargestElementInAnArrayEfficient(int arr[]) {
        int result = -1;
        int largest = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]>arr[largest]) {
                result = largest;
                largest = i;
            }
            else if (arr[i]!=arr[largest]) {
                if (result==-1 || arr[i]>arr[result]) {
                    result = i;
                }
            }
        }
        return result;
    }
}
