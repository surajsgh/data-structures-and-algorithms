import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix {

    // In order to convert it to prefix
    // 1. Reverse the whole string
    // 2. Replace every brackets with its opposite ones
    // 3. Use infix to postfix logic
    // 4. Reverse the string again.
    // 5. You got your answer

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static String infixToPostfix(String exp)
    {
        // Your code here
        int n = exp.length();
        String str = new String("");
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            char character = exp.charAt(i);

            if(Character.isLetterOrDigit(character)) {
                str += character;
            }
            else if(character=='(') {
                stack.push(character);
            }
            else if(character==')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    str += stack.pop();
                }

                if(!stack.isEmpty() && stack.peek()!='(') {
                    return "Invalid Expression";
                }
                else {
                    stack.pop();
                }
            }
            else {
                while(!stack.isEmpty() && precedence(character) <= precedence(stack.peek())) {
                    str += stack.pop();
                }
                stack.push(character);
            }
        }

        while(!stack.isEmpty()) {
            str += stack.pop();
        }

        return str;
    }

    public static int precedence(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
