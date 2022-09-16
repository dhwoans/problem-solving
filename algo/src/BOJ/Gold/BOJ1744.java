package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1744 {

    private static int answer;
    private static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sum = 0;
        answer = 0;
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
        }
        answer = sum;
        mul(plus);
        mul(minus);
        System.out.println(answer);
    }

    private static void mul(PriorityQueue<Integer> que) {
        while(que.size()>1){
            if(que.peek()==1)break;
            int num1 = que.poll();
            if(que.peek()==1)break;
            int num2 = que.poll();
            sum -=(num1+num2);
            sum +=num1*num2;
            answer =  Math.max(answer, sum);
        }
    }
}
