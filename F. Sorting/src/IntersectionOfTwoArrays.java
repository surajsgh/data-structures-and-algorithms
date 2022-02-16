import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
//        findIntersectionNaive(new int[]{1, 20, 20, 20, 40, 50}, new int[]{2, 20, 20, 20});
        findIntersectionEfficient(new int[]{1, 20, 20, 20, 40, 50}, new int[]{2, 20, 20, 20});
    }

    //  This method returns an array.
    //  Time Complexity : O(m+n)
    //  Auxiliary Space : O(m+n)
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i<m; i++) {
            set1.add(nums1[i]);
        }
        for(int i=0; i<n; i++) {
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);

        int[] temp = new int[set1.size()];
        int k = 0;
        for(int i : set1) {
            temp[k++] = i;
        }
        return temp;
    }

//    Time Complexity : O(m+n)
//    Auxiliary Space : O(1)
    public static void findIntersectionEfficient(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        while (i<m && j<n) {
            if ( i>0 && arr1[i]==arr1[i-1]) {
                i++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

//    Time Complexity : O(m*n)
//    Auxiliary Space : O(1)
    public static void findIntersectionNaive(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        for (int i=1; i<m; i++) {
            if (arr1[i]==arr1[i-1]) {
                continue;
            }
            for(int j=0; j<n; j++) {
                if (arr1[i]==arr2[j]) {
                    System.out.print(arr1[i]);
                    break;
                }
            }
        }
    }
}
