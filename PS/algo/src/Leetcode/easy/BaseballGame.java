package Leetcode.easy;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int sum =0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if(op.equals("+")){
                int point =stack.pop();
                int point2 = stack.pop();
                stack.add(point2);
                stack.add(point);
                stack.add(point+point2);
            }else if(op.equals("D")){
                stack.add(stack.peek()*2);
            }else if(op.equals("C")){
                stack.pop();
            }else{
                stack.add(Integer.parseInt(op));
            }
        }
        System.out.println(stack.toString());
        for (Integer i : stack) {
            sum+=i;
        }
        return sum;
    }
}