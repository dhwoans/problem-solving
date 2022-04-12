package programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class 짝지어_제거하기 {
    public int solution(String s){
        int answer = 0;
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : ch) {
            if (stack.isEmpty()) {
                stack.push(c);

            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            answer=1;
        }
        return answer;
    }
}