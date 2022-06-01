package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.push(c);

            } else if (c == '/' || c == '*') {

                if (!stack.isEmpty() && (stack.peek() == '/' || stack.peek() == '*')) {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') {
                            break;
                        }
                        sb.append(stack.pop());
                    }
                }
                stack.push(c);

            }

        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
