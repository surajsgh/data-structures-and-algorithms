import java.util.ArrayList;

public class UnderscorifySubstring {
    //  Time Complexity : O(n + m) It's okay if I just answer the time complexity as O(N(N+M)). O(N+M) is the perfect answer.
    //  Auxiliary Space : O(n)
    public static String underscorifySubstring(String str, String substring) {
        // Write your code here.
        ArrayList<Integer[]> resultList = merge(getLocations(str, substring));
        return underscorify(str, resultList);
    }

    public static ArrayList<Integer[]> getLocations(String str, String substring) {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        int startIdx = 0;

        while(startIdx < str.length()) {
            int nextIdx = str.indexOf(substring, startIdx);
            if(nextIdx!=-1) {
                list.add(new Integer[]{nextIdx, nextIdx + substring.length()});
                startIdx = nextIdx + 1;
            }
            else {
                break;
            }
        }

        return list;
    }

    public static ArrayList<Integer[]> merge(ArrayList<Integer[]> list) {
        if(list.size()==0) return list;
        ArrayList<Integer[]> newList = new ArrayList<Integer[]>();
        newList.add(list.get(0));
        Integer[] prev = list.get(0);

        for(int i=1; i<list.size(); i++) {
            Integer[] curr = list.get(i);
            if(curr[0] <= prev[1]) {
                prev[1] = curr[1];
            }
            else {
                newList.add(curr);
                prev = curr;
            }
        }
        return newList;
    }

    public static String underscorify(String str, ArrayList<Integer[]> list) {
        int locationIdx = 0;
        int stringIdx = 0;
        boolean inBetween = false;
        ArrayList<String> finalChars = new ArrayList<String>();
        int i = 0;

        while(locationIdx < list.size() && stringIdx < str.length()) {
            if(stringIdx == list.get(locationIdx)[i]) {
                finalChars.add("_");
                inBetween = !inBetween;
                if(!inBetween) {
                    locationIdx++;
                }
                i = i == 1 ? 0 : 1;
            }
            finalChars.add(String.valueOf(str.charAt(stringIdx)));
            stringIdx++;
        }
        if(locationIdx < list.size()) {
            finalChars.add("_");
        }
        else if(stringIdx < str.length()) {
            finalChars.add(str.substring(stringIdx));
        }
        return String.join("", finalChars);
    }
}
