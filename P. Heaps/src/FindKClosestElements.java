import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;
        List<Integer> list = new ArrayList<>();

        while(high-low>=k) {
            if(Math.abs(arr[low]-x) > Math.abs(arr[high]-x)) {
                low++;
            }
            else {
                high--;
            }
        }

        for(int i=low; i<=high; i++) {
            list.add(arr[i]);
        }

        return list;
    }

    //  Time Complexity : O(logn)
    public List<Integer> findClosestElementsEfficient(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;

        while(low<high) {
            int mid = (low+high)/2;
            if(x-arr[mid] > arr[mid+k]-x) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return Arrays.stream(arr, low, low + k).boxed().collect(Collectors.toList());
    }
}
