// You're given an array of some input numbers, now you're supposed to compare the sum to the total sum of input array elements and return the
// proper output.
public class CountSubsets {
    public static void main(String[] args) {
        System.out.println(countSubsets(new int[]{10, 20, 15}, 3, 25));
    }

//    Time Complexity : O(2^n)
    public static int countSubsets(int inputArray[], int n, int sum) {
        if (n==0) {
            return (sum==0)?1:0;
        }
        return countSubsets(inputArray, n-1, sum) + countSubsets(inputArray, n-1, sum-inputArray[n-1]);
    }
}
