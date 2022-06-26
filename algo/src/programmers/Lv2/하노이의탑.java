package programmers.Lv2;

import java.util.ArrayList;
import java.util.List;


public class 하노이의탑 {

    private List<int[]> answer;

    public int[][] solution(int n) {
        answer = new ArrayList<>();
        move(n,1,2,3);
        return answer.toArray(new int[0][0]);
    }

    private void move(int n,int from,int via,int to) {
        if(n==0)return;

        move(n-1,from,to,via);
        answer.add(new int[]{from,to});
        move(n-1,via,from,to);
    }
}
