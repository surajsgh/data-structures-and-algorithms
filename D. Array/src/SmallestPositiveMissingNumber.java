public class SmallestPositiveMissingNumber {
//    Time Complexity : O(n)
//    Auxiliary Space : O(n)
    static int missingNumber(int arr[], int size)
    {
        int n = arr.length;

        boolean[] present = new boolean[n+1];

        for(int i=0; i<n; i++) {
            if(arr[i] > 0 && arr[i] <= n) {
                present[arr[i]] = true;
            }
        }

        for(int i=1; i<=n; i++) {
            if(!present[i]) {
                return i;
            }
        }

        return n+1;
    }

//    Time Complexity : O(n)
//    Auxiliary Space : O(1)
    public static int missingNumberEfficient(int[] arr) {
        int n = arr.length;
        int result = 0;

        for (int i=0; i<n; i++) {
            if (arr[i]==1) {
                result = 1;
                break;
            }
        }

        if (result==0) {
            return 1;
        }

        for (int i=0; i<n; i++) {
            if (arr[i]<=0 || arr[i]>n) {
                arr[i] = 1;
            }
        }

        for (int i=0; i<n; i++) {
            arr[(arr[i]-1)%n] += n;
        }

        for (int i=0; i<n; i++) {
            if (arr[i] <= n) {
                return i+1;
            }
        }

        return n+1;
    }
}
