// A pair(arr[i], arr[j]) forms a pair when i<j and arr[i]>arr[j]
public class CountInversionsInAnArray {
    public static void main(String[] args) {
        System.out.println(countInversionsNaive(new int[]{40, 30, 20, 10}));
        System.out.println(countInversionsEfficient(new int[]{40, 30, 20, 10}, 0, 3));
    }

//    Time Complexity : O(n*n)
//    Auxiliary Space : O(1)
    public static int countInversionsNaive(int[] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if ((j > i) && (arr[i]>arr[j])) {
                    count++;
                }
            }
        }
        return count;
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(n)
    public static int countInversionsEfficient(int[] arr, int left, int right) {
        int res = 0;
        if (left < right) {
            int middle = (left+right)/2;
            res += countInversionsEfficient(arr, left, middle);
            res += countInversionsEfficient(arr, middle+1, right);
            res += countInversionsAndMerge(arr, left, middle, right);
        }
        return res;
    }

    public static int countInversionsAndMerge(int arr[], int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        for (int i=0; i<n1; i++) {
            arr1[i] = arr[i + left];
        }
        for (int j=0; j<n2; j++) {
            arr2[j] = arr[middle + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        int res = 0;
        while (i<n1 && j<n2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            }
            else {
                arr[k] = arr2[j];
                j++;
                res = res + (n1 - i);
            }
            k++;
        }
        while (i<n1) {
            arr[k] = arr1[i];
            k++;
            i++;
        }
        while (j<n2) {
            arr[k] = arr2[j];
            k++;
            j++;
        }
        return res;
    }
}
