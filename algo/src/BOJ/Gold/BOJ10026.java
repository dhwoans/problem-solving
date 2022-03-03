package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026 {
    private static class xy {
        int x;
        int y;

        private xy(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    private static boolean[][] visited;
    private static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        visited = new boolean[n][n];
        StringBuilder sb = new StringBuilder();

        //정보 입력
        for (int i = 0; i < map1.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map1[i].length; j++) {
                map1[i][j]= str.charAt(j);
                if(map1[i][j]=='B'){
                    map2[i][j]='B';
                }
            }
        }
        //정상인
        int count =0;
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[i].length; j++) {
                if(!visited[i][j]){
                    visited[i][j]=true;
                    bfs(i,j,map1);
                    count++;
                }
            }
        }
        sb.append(count).append(" ");

        //색약자
        visited = new boolean[n][n];
        count =0;
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                if(!visited[i][j]){
                    visited[i][j]=true;
                    bfs(i,j,map2);
                    count++;
                }
            }
        }
        sb.append(count);

        System.out.println(sb);
    }

    private static void bfs(int x,int y,int[][] map) {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(x,y));

        while (!que.isEmpty()){
            xy z = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length || visited[nx][ny]) continue;

                if (map[nx][ny] == map[x][y]) {
                    visited[nx][ny] = true;
                    que.add(new xy(nx, ny));
                }
            }


        }
    }
}
