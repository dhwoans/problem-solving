package Leetcode.easy;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
       String s1= make(s);
       String s2= make(t);

        return s1.equals(s2);
    }

    private String make(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp=='#'){
                if(stack.isEmpty())continue;
                stack.pop();
            }else{
                stack.add(temp);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
