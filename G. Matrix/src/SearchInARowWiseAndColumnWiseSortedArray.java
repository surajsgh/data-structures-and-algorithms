public class SearchInARowWiseAndColumnWiseSortedArray {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4, 22},
                        {5, 6, 7, 8, 17, 19},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        searchNaive(arr, 19);
        searchEfficient(arr, 12);
    }

//    Time Complexity : O(m*n)
//    Auxiliary Space : O(1)
    public static void searchNaive(int arr[][], int x) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                if (arr[i][j]==x) {
                    System.out.print("Place of x : " + i + " & " + j);
                    return;
                }
            }
        }
        System.out.print("Not Found!");
    }

    public static int R = 4, C = 4;

//    Time Complexity : O(R + C)
//    Auxiliary Space : O(1)
    public static void searchEfficient(int arr[][], int x) {
        int i=0, j=arr[i].length-1;
        while (i<C && j>=0) {
            if (arr[i][j]==x) {
                System.out.print("Positions of x : " + i + " & " + j);
                return;
            }
            else if (arr[i][j]>x) {
                j--;
            }
            else {
                i++;
            }
        }
        System.out.println("Not Found!");
    }
}
