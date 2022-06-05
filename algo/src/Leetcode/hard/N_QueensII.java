package Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class N_QueensII {
    public boolean[] visited;
    public List<Integer> pick;
    public int count;

    public int totalNQueens(int n) {
        //퀸배치
        visited = new boolean[n];
        pick = new ArrayList<>();
        count =0;

        put(0, n);

        return count;
    }

    private void put(int cnt, int n) {
        if (cnt == n) {
            //그려내기
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < pick.size(); j++) {
                int temp = Math.abs(j - cnt);
                if (pick.get(j) - temp == i || pick.get(j) + temp == i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (visited[i]) continue;
                visited[i] = true;
                pick.add(i);
                put(cnt + 1, n);
                visited[i] = false;
                pick.remove(pick.size() - 1);
            }
        }
    }
}