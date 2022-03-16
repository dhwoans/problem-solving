package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17070 {

    private static boolean[][] visited;
    private static int[][] map;
    private static int n;
    private static int[][] dir ={{0,1},{1,0},{1,1}};//가로 세로 대각선
    private static int count;

    private static class xy{
        int x;
        int y;
        int status;// 0 가로 , 1 세로 , 2 대각선

        private xy(int x,int y,int status){
            this.x=x;
            this.y=y;
            this.status = status;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        count = 0;

        //자료 입력
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        if(map[n-1][n-1]==1){
            System.out.println(0);
        }else{
            bfs();
            System.out.println(count);
        }
    }

    private static void bfs() {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(0,1,0));


        while (!que.isEmpty()){
            xy z = que.poll();

            if(z.x==n-1&&z.y==n-1){
                count++;
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < 3; i++) {

                int nx = z.x+dir[i][0];
                int ny = z.y+dir[i][1];

                if(nx<0||ny<0||nx>=n||ny>=n){
                    flag = false;
                    continue;
                }
                if(map[nx][ny]==1){
                    flag = false;
                    continue;
                }

                if((z.status==0&&i==1)||(z.status==1&&i==0))continue;

                if(i!=2){
                    que.add(new xy(nx,ny,i));
                    map[nx][ny]-=1;
                }
                if(i==2&&flag) {
                    que.add(new xy(nx, ny, i));
                    map[nx][ny] -= 1;
                }
            }

        }
    }
}
