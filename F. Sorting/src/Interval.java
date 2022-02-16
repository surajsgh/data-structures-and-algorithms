//Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive
//intervals. Let the intervals be represented as pairs of integers for simplicity.
//For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other,
//so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}.

import java.util.Arrays;

public class Interval implements Comparable<Interval>{
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval interval) {
        return this.start - interval.start;
    }

//    Time Complexity : O(nlog(n))
//    Auxiliary Space : O(1)
    public static void mergeIntervals(Interval arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = 0;
        for (int i=1; i<n; i++) {
            if (arr[res].end >= arr[i].start) {
                arr[res].end = Math.max(arr[res].end, arr[i].end);
                arr[res].start = Math.min(arr[res].start, arr[i].start);
            }
            else {
                res++;
                arr[res] = arr[i];
            }
        }
        for (int i=0; i<=res; i++) {
            System.out.println(arr[i].start + " " + arr[i].end);
        }
    }

    public static void main(String[] args) {
        Interval arr[] = {new Interval(5, 10), new Interval(3, 15), new Interval(18, 30), new Interval(2, 7)};
        mergeIntervals(arr);
    }
}
