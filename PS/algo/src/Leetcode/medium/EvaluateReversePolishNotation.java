package Leetcode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    private Stack<Integer> stack;

    public int evalRPN(String[] tokens) {
        stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("+") || token.equals("/") || token.equals("-")) {
                cal(token);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private void cal(String token) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        if (token.equals("*")) stack.add(num1 * num2);
        else if (token.equals("+")) stack.add(num1 + num2);
        else if (token.equals("/")) stack.add(num2 / num1);
        else if (token.equals("-")) stack.add(num2 - num1);
    }
}
