// A program to merge two sorted arrays.
// Note : This is not a merge sort algorithm.

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = {10, 15, 20, 20};
        int b[] = {1, 12};
        mergeSortNaive(a, b);
        mergeSortEfficient(a, b);
    }

//    Time Complexity : O((m+n)log(m+n))
//    Auxiliary Space : O(m+n)
    public static void mergeSortNaive(int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        int c[] = new int[m+n];
        for (int i = 0; i<m; i++) {
            c[i] = a[i];
        }
        for (int j = 0; j<n; j++) {
            c[m+j] = b[j];
        }
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }

//    Time Complexity : O(m+n)
//    Auxiliary Space : O(1)
    public static void mergeSortEfficient(int a[], int b[]) {
        int i = 0;
        int j = 0;
        int m = a.length;
        int n = b.length;
        while (i<m && j<n) {
            if ((a[i] <= b[j])) {
                System.out.print(a[i] + " ");
                i++;
            }
            else {
                System.out.print(b[j] + " ");
                j++;
            }
        }
        while (i<m) {
            System.out.print(a[i] + " ");
            i++;
        }
        while (j<n) {
            System.out.print(b[j] + " ");
            j++;
        }
    }
}
