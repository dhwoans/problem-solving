package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer.add(-1);
            } else {
                answer.add(stack.peek());
            }
            stack.add(arr[i]);
        }
        while(!answer.isEmpty()){
            sb.append(answer.pop()).append(" ");
        }
        System.out.println(sb);
    }
}

