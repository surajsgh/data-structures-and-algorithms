// Write a program to print leaders element from an array.
// Leader elements are those elements in an array which is greater than every elements present in the right position of the array.
public class LeadersInAnArray {
    public static void main(String[] args) {
        leadersNaive(new int[]{1, 10, 22, 34, 44, 12, 11});
        leadersEfficient(new int[]{1, 10, 22, 34, 44, 12, 11});
    }

//    Time Complexity : O(n^2)
//    Auxiliary Space : O(1)
    public static void leadersNaive(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            boolean flag = false;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]<=arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag==false) {
                System.out.println(arr[i]);
            }
        }
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static void leadersEfficient(int arr[]) {
        int currentLeader = arr[arr.length-1];
        System.out.println(currentLeader);
        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i]>currentLeader) {
                currentLeader = arr[i];
                System.out.println(currentLeader);
            }
        }
    }
}
