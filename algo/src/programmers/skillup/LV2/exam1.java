package programmers.skillup.LV2;

import java.util.LinkedList;
import java.util.Queue;

public class exam1 {

    private boolean[][] visited;
    private int answer;
    private int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};
    private int count;

    private class xy{
        int x;
        int y;

        private xy(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(int[][] board) {
        visited = new boolean[board.length][board[0].length];
        answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==1&&!visited[i][j]){
                    count = 0;
                    visited[i][j]=true;
                    bfs(i, j,board);
                    count++;
                }
            }
        }

        return Math.max(answer,count);
    }

    private void bfs(int i, int j,int[][] map) {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(i,j));

        while(!que.isEmpty()){
            xy z =que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = z.x+dir[k][0];
                int ny = z.y+dir[k][1];

                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)continue;
                if(map[nx][ny]==1&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    que.add(new xy(nx,ny));
                    count++;
                }
            }
        }
    }
}