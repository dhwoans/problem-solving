package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @packageName : BOJ.Sliver
 * @fileName : BOJ_1427_소트인사이트
 * @date : 2021. 11. 29.
 * @language : JAVA
 * @classification : sort
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 *
 **/
public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (num>0){
            que.add(num%10);
            num/=10;
        }

        while (!que.isEmpty()){
            System.out.print(que.poll());
        }
    }
}
