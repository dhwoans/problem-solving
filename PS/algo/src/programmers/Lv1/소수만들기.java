package programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class 소수만들기 {

    private Map<Integer, Boolean> filter;
    private boolean[] visited;
    private int answer;

    public int solution(int[] nums) {
        answer = 0;
        //조합만들기
        visited = new boolean[nums.length];
        dfs(0,0,0, nums);
        return answer;

    }

    private void dfs(int cnt,int start,int sum,int[] nums) {
        if(cnt==3){
            boolean flag = true;
            for (int i = 2; i < sum; i++) {
                if(sum%i==0){
                    flag=false;
                    break;
                }
            }
            if(flag)answer++;
        }
        for (int i = start; i < nums.length; i++) {
            if(visited[i])continue;
            visited[i]=true;
            dfs(cnt+1,i,sum+nums[i],nums);
            visited[i]=false;
        }
    }
}

