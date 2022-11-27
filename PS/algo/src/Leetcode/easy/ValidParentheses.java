package Leetcode.easy;

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {
                if(stack.peek()=='('&&s.charAt(i)==')'){
                    stack.pop();
                }else if(stack.pop()=='['&&s.charAt(i)==']'){
                    stack.pop();
                }else if(stack.pop()=='{'&&s.charAt(i)=='}'){
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
