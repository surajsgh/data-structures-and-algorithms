import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfAStream {
    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(n)
    public static void findMedianNaive(double[] arr, int n) {
        double[] temp = new double[n];
        int size = 0;
        for (int i=0; i<n; i++) {
            temp[i] = arr[i];
            size++;
            int j = i;
            while (j > 0 && temp[j] < temp[j - 1]) {
                swap(temp[j], temp[j - 1]);
                j--;
            }
            if (size%2!=0) {
                System.out.print(arr[size/2]);
            }
            else {
                System.out.println((arr[size/2]+arr[size-1/2])/2);
            }
        }
    }

    public static void swap(double first, double second) {
        double temp = first;
        first = second;
        second = temp;
    }

    //  Time Complexity : O(nlogn)
    public static void findMedianEfficient(double[] arr, int n) {
        Queue<Double> minHeap = new PriorityQueue<Double>();
        Queue<Double> maxHeap = new PriorityQueue<Double>(Collections.reverseOrder());
        maxHeap.add(arr[0]);
        System.out.print(arr[0] + " ");

        for (int i=1; i<n; i++) {
            if (maxHeap.size() > minHeap.size()) {
                if (maxHeap.peek() > arr[i]) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[i]);
                }
                else {
                    minHeap.add(arr[i]);
                }
                System.out.println(minHeap.peek()+maxHeap.peek()/2);
            }
            else {
                if (arr[i] <= maxHeap.peek()) {
                    maxHeap.add(arr[i]);
                }
                else {
                    minHeap.add(arr[i]);
                    maxHeap.add(minHeap.poll());
                }
                System.out.println(minHeap.peek());
            }
        }
    }

    //  Leetcode version
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    boolean even = true;

    //  Time Complexity : O(logn)
    //  Auxiliary Space : O(1)
    public void addNum(int num) {
        if(even) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        even = !even;
    }

    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public double findMedian() {
        if(even) {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        else {
            return maxHeap.peek();
        }
    }
}
