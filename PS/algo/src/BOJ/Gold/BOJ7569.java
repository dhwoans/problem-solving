package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    private static Queue<xy> que;
    private static int[] dem = {-1,1};
    private static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    private static int m;
    private static int n;
    private static int h;
    private static int answer;

    private static class xy{
        int z;
        int x;
        int y;


        private xy(int z,int x,int y){
            this.z=z;
            this.x=x;
            this.y=y;
        }
    }

    private static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[h][n][m];
        que = new LinkedList<>();

        //정보 입력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    map[i][j][k]= Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==1){
                        que.add(new xy(i,j,k));
                    }
                }
            }
        }
        bfs();
        out: for (int[][] ints : map) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if(i==0) {
                        answer = -1;
                        break out;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(){
        while (!que.isEmpty()){
            xy z= que.poll();
                //앞뒤
            for (int i = 0; i < 2; i++) {
                int nz = z.z+dem[i];
                if(nz<0||nz>=h)continue;
                if(map[nz][z.x][z.y]==0){
                    map[nz][z.x][z.y]=map[z.z][z.x][z.y]+1;
                    que.add(new xy(nz,z.x,z.y));
                    answer = Math.max(answer,map[nz][z.x][z.y]-1);
                }
            }
                //상하좌우
                for (int j = 0; j < 4; j++) {
                    int nx = z.x + dir[j][0];
                    int ny = z.y + dir[j][1];

                    if(nx<0||ny<0||nx>=n||ny>=m)continue;
                    if(map[z.z][nx][ny]==0){
                        map[z.z][nx][ny]=map[z.z][z.x][z.y]+1;
                        que.add(new xy(z.z,nx,ny));
                        answer = Math.max(answer,map[z.z][nx][ny]-1);
                    }
                }
        }
    }
}
