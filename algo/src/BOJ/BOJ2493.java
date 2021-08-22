package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer sc = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();


        for(int i = 0; i < N; i ++) {
            int high = Integer.parseInt(sc.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= high) {
                    System.out.print((stack.peek()[0] + 1)+ " ");
                    break;
                } else stack.pop();
            }
            if(stack.isEmpty()) System.out.print(0 + " ");


            stack.push(new int[] {i, high});

        }
        System.out.println(sb);

    }

}