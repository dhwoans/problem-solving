package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]>='A'&&arr[i]<='Z'){
                sb.append(arr[i]);
            }else if(arr[i]=='('){
               stack.push(arr[i]);
            }else if(arr[i]==')'){
                while (stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            }else if(arr[i]=='+'||arr[i]=='-'){
                while (!stack.isEmpty()){
                    if(stack.peek()=='('){
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.push(arr[i]);

            }else if(arr[i]=='/'||arr[i]=='*'){

                if(!stack.isEmpty()&&(stack.peek()=='/'||stack.peek()=='*')){
                    while (!stack.isEmpty()){
                        if(stack.peek()=='('||stack.peek()=='+'||stack.peek()=='-'){
                            break;
                        }
                        sb.append(stack.pop());
                    }
                }
                stack.push(arr[i]);

            }

        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
