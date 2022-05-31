package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

    private static int[][] map;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
    static int[][][] H = {
            { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 } },   // ㅗ
            { { 0, 0 }, { -1, -1}, { 0, -1}, { 1, -1} },   // ㅏ
            { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } },   // ㅓ
            { { 0, 0 }, { -1, -1}, { -1, 0}, { -1, 1} },   // ㅜ
    };
    static boolean[][] visited;
    static int r,c,answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];
        //값 입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                visited[i][j]=true;
                DFS(i,j,0,map[i][j]);
                visited[i][j]=false;
                makeH(i, j);
            }
        }
        System.out.println(answer);
    }
    // ㅏ,ㅓ,ㅗ,ㅜ
    private static void makeH(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int[][] shape = H[k];
            int value = 0;
            for (int[] ints : shape) {
                int nx = i + ints[0];
                int ny = j + ints[1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) break;
                value += map[nx][ny];
            }
            answer = Math.max(answer, value);
        }
    }

    private static void DFS(int i,int j,int count,int val) {
        if(count==3){
            answer = Math.max(answer,val);
            return;
        }
            for (int k = 0; k < 4; k++) {
                int nx = i + dir[k][0];
                int ny = j + dir[k][1];

                if(nx<0||ny<0||nx>=r||ny>=c||visited[nx][ny])continue;
                
                visited[nx][ny]=true;
                DFS(nx,ny,count+1,val+map[nx][ny]);
                visited[nx][ny]=false;
            }
    }
}
