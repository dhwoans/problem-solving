package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String target = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
            if (stack.size() >= target.length()) {
                boolean flag = true;
                for (int j = target.length() - 1; j >= 0; j--) {
                    ArrayList<Character> ch = new ArrayList<>();
                    if (stack.get(stack.size()+j-target.length()) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < target.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
