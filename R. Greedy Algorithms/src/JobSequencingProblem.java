import java.util.Arrays;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {
    public static void main(String[] args) {
        Job[] jobs = {new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25), new Job('e', 3, 15)};
        jobSequence(jobs, 3);
    }

    //  Time Complexity : O(n*n)
    //  Auxiliary Space : O(1)
    private static void jobSequence(Job[] jobs, int limit) {
        Arrays.sort(jobs, (a, b) -> b.profit-a.profit);

        boolean[] result = new boolean[limit];
        Arrays.fill(result, false);

        char[] job = new char[limit];

        for (int i=0; i<jobs.length; i++) {
            for (int j=Math.min(limit-1, jobs[i].deadline-1); j>=0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    job[j] = jobs[i].id;
                    break;
                }
            }
        }

        for (char ch : job) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}
