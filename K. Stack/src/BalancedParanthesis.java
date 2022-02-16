import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String str = "}";
        System.out.println(isBalanced(str));
    }

    //  Time Complexity : O(n)
    //  Auxiliary Space : O(n)
    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i=0; i<str.length(); i++) {
            char x = str.charAt(i);
            if (x=='{' || x=='[' || x=='(') {
                stack.push(x);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else if (!matching(stack.peek(), x)) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean matching(char a,char b){
        return (( a=='(' && b==')' )||( a=='[' && b==']' )||( a=='{' && b=='}' ));
    }
}
