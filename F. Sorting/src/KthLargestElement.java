import java.util.PriorityQueue;

public class KthLargestElement {
    //  Time Complexity : O(nlogk)
    //  Auxiliary Space : O(k)
    public int findKthLargestAlt(int[] nums, int k) {
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num : nums) {
            queue.add(num);

            index++;

            if(index > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int index = quickSelect(nums, n, k);
        return nums[index];
    }

    public int quickSelect(int[] nums, int n, int k) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right) {
            int p = quickSelectPartition(nums, left, right);
            if(p==n-k) {
                return p;
            }
            else if(p<n-k) {
                left = p+1;
            }
            else {
                right = p-1;
            }
        }
        return -1;
    }

    public int quickSelectPartition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for(int j=left; j<right; j++) {
            if(nums[j]<pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, right);
        return i+1;
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
