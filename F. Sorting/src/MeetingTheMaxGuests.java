import java.util.Arrays;

public class MeetingTheMaxGuests {
    public static void main(String[] args) {
        System.out.println(maxGuestYouCanMeet(new int[]{800, 700, 600, 500}, new int[]{840, 820, 830, 530}));
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(1)
    public static int maxGuestYouCanMeet(int arr[], int dep[]) {
        int result = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1, j=0, curr=1;
        while (i<arr.length && j<dep.length) {
            if (arr[i] <= dep[j]) {
                curr++;
                i++;
            }
            else {
                curr--;
                j++;
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}
