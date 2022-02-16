public class TwoOddNumberOccuring {
    public static void main(String[] args) {
        oddAppearingNaive(new int[]{4, 4, 4, 4, 5, 3, 3, 3});
        int arr[] = new int[]{4, 4, 4, 4, 5, 3, 3, 3};
        twoOddNumberAppearingEfficient(arr, arr.length);
    }

//     Time Complexity : O(n^2)
//     Auxiliary Space : O(1)
    public static void oddAppearingNaive(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            int count=0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                }
            }
            if (count%2 != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void twoOddNumberAppearingEfficient(int arr[], int n) {
        int result1 = 0;
        int result2 = 0;
        int XOR = 0;
        for (int i=0; i<n; i++) {
            XOR ^= arr[i];
        }
        int andResult = XOR & ~(XOR-1);
        for (int i=0; i<n; i++) {
            if ((andResult & arr[i]) !=0) {
                result1 = result1 ^ arr[i];
            }
            else {
                result2 = result2 ^ arr[i];
            }
        }
        System.out.print(result1 + " " + result2);
    }
}
