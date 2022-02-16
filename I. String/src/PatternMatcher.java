import java.util.HashMap;

public class PatternMatcher {
    //  Time Complexity : O(N*N + M)
    //  Auxiliary Space : O(N + M)
    //  Where N = length of input string
    //  M = Length of input pattern
    public static String[] patternMatcher(String pattern, String str) {
        if(pattern.length() > str.length()) return new String[]{};

        //  Length of input pattern auxiliary space and time complexity
        char[] newPattern = findNewPattern(pattern);
        boolean isChanged = newPattern[0]!=pattern.charAt(0);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('x', 0);
        map.put('y', 0);

        //  Traversal of pattern array in O(M) time.
        int firstYPos = getCountAndFindYPos(newPattern, map);
        if(map.get('y')!=0) {
            //  Traversal of input string in O(N) time complexity
            for(int lenX = 1; lenX<str.length(); lenX++) {
                int lenY = (str.length() - lenX * map.get('x'))/map.get('y');
                if(lenY<=0 || lenY%1 != 0) continue;
                int yIdx = lenX * firstYPos;

                //  Generation of string of length N in each iteration for auxiliary space
                //  Generation of string, building new string patterns and then comparing it takes O(N) time.
                String x = str.substring(0, lenX);
                String y = str.substring(yIdx, yIdx + lenY);
                String newString = compareAndForm(newPattern, x, y);
                if(str.equals(newString)) {
                    return isChanged ? new String[]{y, x} : new String[]{x, y};
                }
            }
        }
        else {
            int lenX = str.length()/map.get('x');
            if(lenX%1 == 0) {
                String x = str.substring(0, lenX);
                String newString = compareAndForm(newPattern, x, "");
                if(str.equals(newString)) {
                    return isChanged ? new String[]{"", x} : new String[]{x, ""};
                }
            }
        }
        return new String[] {};
    }

    public static char[] findNewPattern(String pattern) {
        char[] newPattern = pattern.toCharArray();
        if(pattern.charAt(0)=='x') return newPattern;
        for(int i=0; i<newPattern.length; i++) {
            if(newPattern[i]=='x') {
                newPattern[i] = 'y';
            }
            else {
                newPattern[i] = 'x';
            }
        }
        return newPattern;
    }

    public static int getCountAndFindYPos(char[] characters, HashMap<Character, Integer> map) {
        int yPos = -1;
        for(int i=0; i<characters.length; i++) {
            map.put(characters[i], map.get(characters[i])+1);
            if(characters[i]=='y' && yPos==-1) yPos = i;
        }
        return yPos;
    }

    public static String compareAndForm(char[] newPattern, String x, String y) {
        StringBuilder strBuilder = new StringBuilder();
        for(char ch : newPattern) {
            if(ch=='x') {
                strBuilder.append(x);
            }
            else {
                strBuilder.append(y);
            }
        }
        return strBuilder.toString();
    }
}
