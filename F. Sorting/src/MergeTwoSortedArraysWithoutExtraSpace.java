public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
//        int arr1[] = new int[]{3, 5, 6, 8, 12};
//        int arr2[] = new int[]{1, 4, 9, 13};
//        mergeArrays(arr1, arr2, arr1.length, arr2.length);
        int[] a1 = { 10, 27, 38, 43, 82 };
        int[] a2 = { 3, 9 };
        mergeEfficient(a1, a2, a1.length, a2.length);
        System.out.println();
        for (int i=0; i<a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        for (int j=0; j<a2.length; j++) {
            System.out.print(a2[j] + " ");
        }
    }

//    Time Complexity : O(m*n)
//    Auxiliary Space : O(1)
    public static void mergeArrays(int[] arr1, int[] arr2, int m, int n) {
        for (int i=0; i<m; i++) {
            if (arr1[i]>arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            int firstElement = arr2[0];
            int k;
            for (k=1; k<n && arr2[k]<firstElement; k++) {
                arr2[k-1] = arr2[k];
            }
            arr2[k-1] = firstElement;
        }
        for (int i:arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j:arr2) {
            System.out.print(j + " ");
        }
    }

    public static int nextGap(int gap) {
        if (gap<=1) {
            return 0;
        }
        return gap/2 + gap%2;
    }

//  Time Complexity : O(m+n(log(m+n)))
//  Auxiliary Space : O(1)
    public static void mergeEfficient(int[] arr1, int[] arr2, int m, int n) {
        int i, j, gap = (m + n);
        for (gap = nextGap(gap); gap>0; gap=nextGap(gap)) {
//          Comparing elements in the first array.
            for (i=0; i+gap<m; i++) {
                if (arr1[i]>arr1[i+gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[gap+i];
                    arr1[i+gap] = temp;
                }
            }

//          Comparing elements in both the arrays.
            for (j=(gap>m)?gap-m:0; i<m && j<n; i++, j++) {
                if (arr1[i]>arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

//          Comparing elements in the second array.
            if (j<n) {
                for (j=0; j+gap<n; j++) {
                    if (arr2[j]>arr2[j+gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
        }
    }
}
