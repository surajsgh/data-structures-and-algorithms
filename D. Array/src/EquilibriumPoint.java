public class EquilibriumPoint {
    public static void main(String[] args) {
        System.out.println(findEquilibriumPoint(new int[]{4, 1, -2}));
        System.out.println(findEquilibriumPointEfficient(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }

//    Time Complexity : O(n^2)
//    Auxiliary Space : O(1)
    public static boolean findEquilibriumPoint(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j=0; j<i; j++) {
                leftSum += arr[j];
            }
            for (int k=i+1; k<arr.length; k++) {
                rightSum += arr[k];
            }
            if (leftSum==rightSum) {
                return true;
            }
        }
        return false;
    }
    
//     Time Complexity : O(n)
//     Space Complexity : O(1)
    public static int findEquilibriumPointEfficient(int arr[]) {
        int sum = 0;
        int leftSum = 0;
        
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        
        for (int i=0; i<arr.length; i++) {
            sum -= arr[i];
            
            if(sum == leftSum) {
                return i + 1;
            }
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}
