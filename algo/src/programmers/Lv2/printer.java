package programmers.Lv2;

import java.util.*;

public class printer {
    public int solution(int[] priorities, int location) {
        int point = priorities.length-1;
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que.add(new int[]{i,priorities[i]});
        }
        Arrays.sort(priorities);
        while(true){
            if(que.isEmpty())break;
            if(que.peek()[1]>=priorities[point]){
                int[] z = que.poll();
                answer++;
                if(z[0]==location)break;
                point--;
            }else{
                que.add(que.poll());
            }
        }

        return answer;
    }
}
