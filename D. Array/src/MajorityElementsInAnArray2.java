import java.util.ArrayList;
import java.util.List;

public class MajorityElementsInAnArray2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1 };
        System.out.println(appearsNBy3(arr));
        System.out.println(majorityElement(arr));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static int appearsNBy3(int[] arr) {
        int n = arr.length;
        int number1 = Integer.MAX_VALUE;
        int number2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int i=0; i<n; i++) {
            if (number1==arr[i]) {
                count1++;
            }
            else if (number2==arr[i]) {
                count2++;
            }
            else if (count1==0) {
                number1=arr[i];
                count1++;
            }
            else if (count2==0){
                number2=arr[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i=0; i<n; i++) {
            if (arr[i]==number1) {
                count1++;
            }
            else if (arr[i]==number2) {
                count2++;
            }
        }

        if (count1>n/3) {
            return number1;
        }
        if (count2>n/3) {
            return number2;
        }
        return -1;
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int count = 1;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]==nums[j]) {
                    count++;
                }
            }
            if(count>(nums.length/3)) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                }
            }
        }

        return list;
    }
}
