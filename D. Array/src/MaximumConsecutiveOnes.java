public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(new int[]{0, 1, 1, 0, 1, 1, 1, 1, 0}));
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int maxConsecutiveOnes(int arr[]) {
        int result = 0;
        int current = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==0) {
                current = 0;
            }
            else {
                current++;
                result = Math.max(result, current);
            }
        }
        return result;
    }
}
