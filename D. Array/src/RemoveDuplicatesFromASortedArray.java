// Write a program to remove the duplicates from an array.
public class RemoveDuplicatesFromASortedArray {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 4, 4, 5, 5, 5};
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int n = removeDuplicatesNaive(arr);
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int arr1[] = new int[]{3, 12, 34, 22, 22};
        for (int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        n = removeDuplicatesEfficient(arr1);
        for (int i=0; i<n; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(n)
    public static int removeDuplicatesNaive(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        temp[0] = arr[0];
        int res = 1;
        for (int i=1; i<n; i++) {
            if (temp[res-1]!=arr[i]) {
                temp[res]=arr[i];
                res++;
            }
        }
        for (int j=0; j<res; j++) {
            arr[j]=temp[j];
        }
        return res;
    }

//    Time Complexity : O(n)
//    Space Complexity : O(1)
//    Since, the above method consumes the array space very much unlike this method, Hence this method is efficient.
    public static int removeDuplicatesEfficient(int arr[]) {
        int res=1;
        for (int i=1; i<arr.length; i++) {
            if (arr[res-1]!=arr[i]) {
                arr[res]=arr[i];
                res++;
            }
        }
        return res;
    }

    //  Leetcode easy version
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int num : nums) {
            if(i==0 || num>nums[i-1]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    //  Leetcode medium version
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int removeDuplicates2(int[] nums) {
        int i=0;
        for(int num : nums) {
            if(i<2 || num > nums[i-2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
