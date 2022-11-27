package programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class gameMap {

    private int answer;
    private int c;
    private int r;

    static private class xy{
        int x;
        int y;
        int count ;

        xy(int x,int y,int count){
            this.x =x;
            this.y =y;
            this.count = count;
        }
    }
    boolean[][] visited;
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    public int solution(int[][] maps) {
        r = maps.length;
        c = maps[0].length;
        answer = -1;
        bfs(0,0,maps);

        return answer;
    }

    private void bfs(int i, int j,int[][] maps) {
        visited = new boolean[r][c];
        visited[i][j]=true;

        Queue<xy> que = new LinkedList<>();
        que.add(new xy(i,j,1));

        while(!que.isEmpty()){
            xy z = que.poll();
            if(z.x==r-1&&z.y==c-1){
                answer = z.count;
                return;
            }
            for (int k = 0; k < 4; k++) {
               int  nx = z.x + dir[k][0];
               int  ny = z.y + dir[k][1];

               if(nx<0||ny<0||nx>=r||ny>=c)continue;
               if(maps[nx][ny]==0||visited[nx][ny])continue;
               visited[nx][ny]=true;
               que.add(new xy(nx,ny,z.count+1));
            }
        }
    }
}