package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ16234
 * @date : 2022-01-22
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ16234 {
    static class xy{
        int x;
        int y;

        private xy(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int N,L,R;
    static int[][] map;
    static int[][] visit;
    static int count;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new int[N][N];
        count = 1;
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            count++;
            //연합파악하기
            int cout =1;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (visit[i][j] == 0) {
                        Bfs(i, j,count);
                        visit[i][j]=count;
                        count++;
                    }
                }
            }
            //인구이동
            int[] countpeo = new int[count];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {

                }
            }
        }
    }

    private static void Bfs(int r,int c,int count) {
        Queue<xy> que =new LinkedList<>();
        que.offer(new xy(r,c));

        while (!que.isEmpty()){
            xy temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];

                if(nr<0||nr>=N||nc<0||nc>N)continue;
                if(map[nr][nc]>=L&&map[nr][nc]<=R&&visit[nr][nc]==0){
                    visit[nr][nc]=count;

                    que.add(new xy(nr,nc));
                }
            }
        }
    }

}
