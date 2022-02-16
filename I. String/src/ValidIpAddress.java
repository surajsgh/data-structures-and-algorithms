import java.util.ArrayList;

public class ValidIpAddress {
    //  Time Complexity : O(1)
    //  Auxiliary Space : O(1)
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        int n = string.length();
        ArrayList<String> list = new ArrayList<>();

        for(int i=1; i<Math.min(n, 4); i++) {
            String[] result = new String[]{"", "", "", ""};

            result[0] = string.substring(0, i);
            if(!isValid(result[0])) continue;

            for(int j=i+1; j<i+Math.min(n-i, 4); j++) {
                result[1] = string.substring(i, j);
                if(!isValid(result[1])) continue;

                for(int k=j+1; k<j+Math.min(n-j, 4); k++) {
                    result[2] = string.substring(j, k);
                    result[3] = string.substring(k);
                    if(isValid(result[2]) && isValid(result[3])) list.add(join(result));
                }
            }
        }
        return list;
    }

    public boolean isValid(String string) {
        int number = Integer.parseInt(string);
        if(number>255) return false;
        return string.length()==Integer.toString(number).length();
    }

    public String join(String[] str) {
        StringBuilder string = new StringBuilder();
        for(int i=0; i<str.length; i++) {
            string.append(str[i]);
            if(i<str.length-1) string.append(".");
        }
        return string.toString();
    }
}
