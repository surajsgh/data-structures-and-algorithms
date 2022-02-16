public class UnionOfTwoArrays {
    public static void main(String[] args) {
        union(new int[]{2, 10, 20, 20}, new int[]{3, 20, 40});
    }

//    Time Complexity : O(m+n)
//    Auxiliary Space : O(1)
    public static void union(int arr1[], int arr2[]) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        while (i<m && j<n) {
            if (i>0 && arr1[i]==arr1[i-1]) {
                i++;
                continue;
            }

            if (j>0 && arr2[j]==arr2[j-1]) {
                j++;
                continue;
            }

            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            }
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
        while (i<m) {
            if (i==0 || arr1[i] != arr1[i-1]) {
                System.out.print(arr1[i] + " ");
                i++;
            }
        }
        while (j<n) {
            if (j==0 || arr2[j] != arr2[j-1]) {
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
    }
}
