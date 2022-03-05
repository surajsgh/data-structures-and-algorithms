import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Compare implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.end-o2.end;
    }
}

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        Activity[] activities = new Activity[]{new Activity(12, 25), new Activity(10, 20), new Activity(20, 30)};
        System.out.println(maxActivity(activities, activities.length));
    }

    //  Time Complexity : O(nlog(n))
    //  Auxiliary Space : O(1)
    private static int maxActivity(Activity[] activities, int n) {
        Arrays.sort(activities, new Compare());
        int res = 1;
        int prev = 0;

        for (int curr=1; curr<n; curr++) {
            if (activities[curr].start>=activities[prev].end) {
                res++;
                prev = curr;
            }
        }

        return res;
    }
}
