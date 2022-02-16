// Write a program to find the majority element in an array.
// A majority element is an element which appears more than n/2 times(Where n=length of the array.)
public class MajorityElement {
    public static void main(String[] args) {
        majorityElement(new int[]{8, 7, 6, 8, 6, 6, 6, 6});
    }

//    Time Complexity : O(n^2)
//    Space Complexity : O(1)
    public static void majorityElement(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                }
            }
            if (count>=(arr.length)/2) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
//     Time Complexity : O(n)
//     Auxiliary Space : O(1)
//     This algorithm is popularly known as Boyer Moore Voting alogrithm.
    public static Integer majorityElementEfficient(int[] arr) {
        Integer candidate = null;
        int count = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(count==0) {
                candidate=arr[i];
            }
            count += (candidate==arr[i])? 1:-1;
        }
        return candidate;
    }
}
