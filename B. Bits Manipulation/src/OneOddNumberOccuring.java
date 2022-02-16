//  A program to findout the odd number of an element in an array.
public class OneOddNumberOccuring {
    public static void main(String[] args) {
        System.out.println(findOdd(new int[]{4, 3, 3, 4, 4, 4, 4}));
    }

//     Time Complexity : O(n)
//     Auxiliary Space : O(1)
//     EX-OR property : 
//     x ^ 0 = x;
//     x ^ y = y ^ x;
//     (x ^ y) ^ z = x ^ (y ^ z)
//     x ^ x = 0
    public static int findOdd(int arr[]) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
