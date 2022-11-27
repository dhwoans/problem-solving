package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Math.max;

public class BOJ25918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var str = br.readLine().toCharArray();
        var max =0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                stack.add(str[i]);
            }else if(stack.peek()=='('&&str[i]==')'||stack.peek()==')'&&str[i]=='('){
                stack.pop();
            }else{
                stack.add(str[i]);
            }
            max = max(max,stack.size());
        }
        if(stack.size()==0){
            System.out.println(max);
        }else{
            System.out.println(-1);
        }
    }
}
