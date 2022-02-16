public class LongestKUniqueCharactersSubstring {
    //  Time Complexity : O(S)
    //  Auxiliary Space : O(1)
    public int longestkSubstr(String s, int k) {
        int[] arr = new int[256];
        int start = 0;
        int end = 0;
        int unique = 0;
        int result = 0;
        int n = s.length();

        while(end<n) {
            while(end<n) {
                if(arr[s.charAt(end)]==0) unique++;
                arr[s.charAt(end)]++;
                if(unique>k) break;
                end++;
            }

            if(unique>=k) result = Math.max(result, end-start);
            if(end==n) break;

            while(start<n) {
                if(arr[s.charAt(start)]==1) unique--;
                arr[s.charAt(start)]--;
                if(unique==k) break;
                start++;
            }
            start++;
            end++;
        }
        if(result==0) return -1;
        return result;
    }
}
