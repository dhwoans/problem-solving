package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int count =k;
        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                stack.add(arr[i]);
                continue;
            }

            if(stack.isEmpty()){
                stack.add(arr[i]);
            }else if(stack.peek()<arr[i]){
                while (!stack.isEmpty() && stack.peek()<arr[i] && count!=0){
                    count--;
                    stack.pop();
                }
                stack.add(arr[i]);
            }else{
                stack.add(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i);
        }

        System.out.println(sb.substring(0,n-k));



    }
}
