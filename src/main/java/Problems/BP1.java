package Problems;

import java.util.Stack;

public class BP1 {

    public static void main(String[] args) {
        System.out.println(isBalancedParanthesis("[[[[[[]]]]]][{}][[{[]}]]"));
        System.out.println(isBalancedParanthesis("]"));
        System.out.println(isBalancedParanthesis(""));
        System.out.println(isBalancedParanthesis("[]"));
    }

    private static boolean isBalancedParanthesis(String expression){
        char []brackets = expression.toCharArray();
        Stack<Character> stack = new Stack();
        for(char bracket: brackets){
            switch (bracket){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.isEmpty() || bracket != stack.peek())
                        return false;
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
