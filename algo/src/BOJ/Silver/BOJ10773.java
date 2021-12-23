package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ10773
 * @date : 2021-12-23
 * @language : JAVA
 * @classification : 구현
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> que = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                que.pop();
            }else{
                que.add(num);
            }
        }

        while (!que.isEmpty()){
            sum+= que.pop();
        }

        System.out.println(sum);
    }
}
