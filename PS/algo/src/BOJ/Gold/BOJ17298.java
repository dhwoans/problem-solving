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
        var ans = new int[arr.length];
        Arrays.fill(ans,-1);
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()||arr[stack.peek()]>=arr[i]){
                stack.add(i);
            }else if(arr[stack.peek()]<arr[i]){
                while(!stack.isEmpty()){
                    if(arr[stack.peek()]<arr[i]){
                        ans[stack.peek()]=arr[i];
                        stack.pop();
                    }else{
                        break;
                    }
                }
                stack.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(ans[i]).append(" ");
        }
            System.out.print(sb);
    }
}

