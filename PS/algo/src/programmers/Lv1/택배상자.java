package programmers.Lv1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < order.length + 1; i++) {
            que.add(i);
        }
        int pointer = 0;
        while (!que.isEmpty()) {
            if (que.peek() != order[pointer]) {
                if(!stack.isEmpty()&&stack.peek()==order[pointer]) {
                    stack.pop();
                    pointer++;
                }
                else stack.add(que.poll());
            } else{
                pointer++;
                que.poll();
            }
        }
        while(true){
            if(!stack.isEmpty()&&stack.peek()==order[pointer]) {
                stack.pop();
                pointer++;
            }else{
                break;
            }
        }

        return pointer;
    }
}
