import java.util.Stack;

public class LongestBalancedSubstring {
    //  Time Complexity : O(n*n*n)
    //  Auxiliary Space : O(n)
    public int longestBalancedSubstring(String string) {
        // Write your code here.
        int maxLength = 0;
        int n = string.length();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(balanced(string.substring(i, j+1))) {
                    int currLength = j-i+1;
                    maxLength = Math.max(maxLength, currLength);
                }
            }
        }

        return maxLength;
    }

    public boolean balanced(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') {
                stack.push('(');
            }
            else if(stack.size() > 0) {
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.size()==0;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public int longestBalancedSubstringBetter(String string) {
        // Write your code here.
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i<string.length(); i++) {
            if(string.charAt(i)=='(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(stack.size()==0) {
                    stack.push(i);
                }
                else {
                    int startIdx = stack.peek();
                    int currLength = i - startIdx;
                    maxLength = Math.max(maxLength, currLength);
                }
            }
        }
        return maxLength;
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(1)
    public int longestBalancedSubstringEfficient(String string) {
        // Write your code here.
        int maxLength = 0;

        int openingCount = 0;
        int closingCount = 0;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (ch == '(') {
                openingCount++;
            } else {
                closingCount++;
            }

            if (openingCount == closingCount) {
                maxLength = Math.max(maxLength, closingCount * 2);
            } else if (closingCount > openingCount) {
                openingCount = 0;
                closingCount = 0;
            }
        }

        openingCount = 0;
        closingCount = 0;

        for (int i = string.length() - 1; i >= 0; i--) {
            char ch = string.charAt(i);

            if (ch == '(') {
                openingCount++;
            } else {
                closingCount++;
            }

            if (openingCount == closingCount) {
                maxLength = Math.max(maxLength, openingCount * 2);
            } else if (closingCount < openingCount) {
                openingCount = 0;
                closingCount = 0;
            }
        }
        return maxLength;
    }
}
