package Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public boolean[] visited;
    public List<Integer> pick;
    private List<List<String>> arr;

    public List<List<String>> solveNQueens(int n) {
        //퀸배치
        visited = new boolean[n];
        pick = new ArrayList<>();

        arr = new ArrayList<>();
        put(0,n);
        //그려내기
        return arr;
    }

    private void put(int cnt,int n) {
        if(cnt==n){
            //그려내기
            pirnt();
            return ;
        }
        for (int i = 0; i < n; i++) {
            boolean flag= true;
            for (int j = 0; j < pick.size(); j++) {
                int temp = Math.abs(j-cnt);
                if(pick.get(j)-temp==i||pick.get(j)+temp==i){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(visited[i])continue;
                visited[i]=true;
                pick.add(i);
                put(cnt+1,n);
                visited[i]=false;
                pick.remove(pick.size()-1);
            }
        }
    }

    private void pirnt() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < pick.size(); i++) {
            String str = "";
            for (int j = 0; j < pick.size(); j++) {
                if(pick.get(i)==j)str+="Q";
                else str+=".";
            }
            list.add(str);
        }
        arr.add(list);
    }
}
