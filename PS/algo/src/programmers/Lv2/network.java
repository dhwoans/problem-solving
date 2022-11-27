package programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @packageName : programmers.Lv2
 * @fileName : network
 * @date : 2022-01-12
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class network {
    static boolean visit[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                Bfs(i,computers);
                answer++;
            }
            
        }
        return answer;
    }

    private void Bfs(int start,int[][] computers) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()){
            int z =que.poll();
            for (int i = 0; i < computers[z].length; i++) {
                if(z==i){
                    visit[i]=true;
                }else if(computers[z][i]==1&&!visit[i]){
                    visit[i]=true;
                    que.add(i);
                }
            }
        }
    }
}
