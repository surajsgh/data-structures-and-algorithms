import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        String str = "Leetcode is so awesome!";
        char[] charString = str.toCharArray();
        reverseWords(charString, str.length());
        System.out.println(charString);
    }

    //  For printing whitespaces as it is shown in the example
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public String reverseWordsInStringBest(String string) {
        // Write your code here.
        char[] characterSet = string.toCharArray();
        int n = characterSet.length;
        reverseBest(characterSet, 0, n-1);

        int startIndex = 0;
        while(startIndex<n) {
            int endIndex = startIndex;
            while(endIndex<n && characterSet[endIndex]!=' ') {
                endIndex++;
            }
            reverseBest(characterSet, startIndex, endIndex-1);
            startIndex = endIndex + 1;
        }
        return new String(characterSet);
    }

    public void reverseBest(char[] characters, int start, int end) {
        while(start<=end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
    }
    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public String reverseWordsInString(String string) {
        // Write your code here.
        int n = string.length();
        List<String> list = new ArrayList<>();
        int startIndex = 0;

        for(int i=0; i<n; i++) {
            char character = string.charAt(i);

            if(character==' ') {
                list.add(string.substring(startIndex, i));
                startIndex = i;
            }
            else if(string.charAt(startIndex)==' ') {
                list.add(" ");
                startIndex = i;
            }
        }

        list.add(string.substring(startIndex));
        Collections.reverse(list);
        return String.join("", list);
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public String reverseWordsAlt(String s) {
        int i = 0;
        int n = s.length();
        String result = new String();

        while(i<n) {
            while(i<n && s.charAt(i)==' ') i++;
            if(i>=n) break;
            int j = i+1;
            while(j<n && s.charAt(j)!=' ') j++;
            String sub = s.substring(i, j);
            if(result.length()==0) {
                result = sub;
            }
            else {
                result = sub + " " + result;
            }
            i = j + 1;
        }
        return result;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public static void reverseWords(char[] str, int n) {
        int start = 0;
        for (int end=0; end<str.length; end++) {
            if (str[end]==' ') {
                reverse(str, start, end-1);
                start = end + 1;
            }
        }
        reverse(str, start, n-1);
        reverse(str, 0, n-1);
    }

    public static void reverse(char[] str, int low, int high) {
        while (low<=high) {
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}
