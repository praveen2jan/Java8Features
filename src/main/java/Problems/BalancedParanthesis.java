package Problems;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        System.out.println(isBalancedParantheses("[][[]]()))"));
        System.out.println(isBalancedParantheses("[][[]]((())){}"));
        System.out.println(isBalancedParantheses("[][[]]()){)"));
    }
    public static String isBalancedParantheses(String expression){

        //check expression length
        if((expression.length() & 1 ) ==1)
            return "Not Balanced";
        char []brackets = expression.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c : brackets){
            switch (c){
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if(stack.isEmpty()||c!=stack.peek())
                        return "Not Balanced";
                    stack.pop();
            }

        }
        if(stack.isEmpty()) return "Balanced";
        else
            return "Not Balanced";
    }
}
