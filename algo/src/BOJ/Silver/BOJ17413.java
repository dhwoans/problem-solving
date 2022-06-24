package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {

    private static Stack<Character> stack;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        stack = new Stack<>();
        sb = new StringBuilder();
        int index = 0;
        while(index <str.length()){
            if(str.charAt(index)==' '){
                pop();
                sb.append(" ");
                index++;
            }else if(str.charAt(index)=='<'){
                if(!stack.isEmpty()){
                    pop();
                }
                while (str.charAt(index)!='>'){
                    sb.append(str.charAt(index));
                    index++;
                }
                sb.append(str.charAt(index));
                index++;
            }else{
                stack.add(str.charAt(index));
                index++;
            }
        }
        if(!stack.isEmpty()){
            pop();
        }
        System.out.println(sb);
    }

    private static void pop() {
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
    }
}
