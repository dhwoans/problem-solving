package programmers.Lv2;

import java.util.*;


public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        int count =0;
        PriorityQueue<Integer> que = new PriorityQueue();
        for (int i : scoville) {
            que.add((i));
        }
        while(true){
            boolean flag = true;
            if(que.peek()>=K){
                break;
            }
            int frist = que.poll();
            int second = que.poll();
            que.add(frist+second*2);
            count++;
            if(que.size()==1){
                count =-1;
                break;
            }
        }
        return count;
    }
}
