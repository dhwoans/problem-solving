package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Sliver
 * @fileName : BOJ_1966_프린터큐
 * @date : 2021. 12. 06.
 * @language : JAVA
 * @classification : queue
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:00
 * @submissions : 1
 * @description
 *
 **/
public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target =Integer.parseInt(st.nextToken());// 몇번째 뽑히는지 알고 싶은 문서
            //문서 입력 받기
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
            Queue<int[]> arr = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                que.add(new int[]{j,priority});
                arr.add(new int[]{j,priority});
            }
            int count =1;
            while(true){
                if(que.peek()[1]==arr.peek()[1]){
                    if(que.peek()[0]==target){
                        break;
                    }else{
                        que.poll();
                        arr.poll();
                        count++;
                    }
                }else{
                    arr.add(arr.poll());
                }
            }
            System.out.println(count);

        }
    }
}
