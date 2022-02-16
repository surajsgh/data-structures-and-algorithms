// Write a program to figure out the frequency of an element in a sorted array.
public class FrequencyInASortedArray {
    public static void main(String[] args) {
        printFrequencyInASortedArray(new int[]{88});
    }

    //    Time Complexity : O(n)
//    Space Complexity : O(1)
    public static void printFrequencyInASortedArray(int arr[]) {
        int freq = 1;
        int i = 1;
        while (i<arr.length) {
            while (i<arr.length && arr[i]==arr[i-1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i-1] + " : " + freq);
            i++;
            freq = 1;
        }
        if (arr.length==1 || arr[arr.length-1]!=arr[arr.length-2]) {
            System.out.println(arr[arr.length-1] + " : " + 1);
        }
    }
}