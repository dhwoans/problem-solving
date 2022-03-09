package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

    private static int answer;
    private static int r;
    private static int c;
    private static int k;
    private static int[][] score;

    private static class xy {
        int x;
        int y;
        int num;
        int skill;

        private xy(int x, int y, int num, int skill) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.skill = skill;
        }
    }

    private static int[][] map;
    private static boolean[][][] visited;
    private static int[][] dir4 = {{-1,0},{1,0},{0,1},{0,-1}};
    private static int[][] dir8 = {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new int[r][c];
        score = new int[r][c];
        visited = new boolean[k+1][r][c];
        
        //정보입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        if(answer==Integer.MAX_VALUE)answer=-1;
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(0,0,0,0));
        visited[0][0][0]=true;

        while (!que.isEmpty()){
            xy z =que.poll();

            if(z.x==r-1&&z.y==c-1){
                answer =z.num;
                break;
            }

            if(z.skill<k){
                for (int i = 0; i < 8; i++) {
                    int nx = z.x + dir8[i][0];
                    int ny = z.y + dir8[i][1];

                    if(nx<0||ny<0||nx>=r||ny>=c)continue;
                    if(!visited[z.skill+1][nx][ny]&&map[nx][ny]==0){
                        visited[z.skill+1][nx][ny]=true;

                        que.add(new xy(nx,ny,z.num+1,z.skill+1));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = z.x +dir4[i][0];
                int ny = z.y +dir4[i][1];

                if(nx<0||ny<0||nx>=r||ny>=c)continue;
                if(!visited[z.skill][nx][ny]&&map[nx][ny]==0){
                    visited[z.skill][nx][ny]=true;

                    que.add(new xy(nx,ny,z.num+1,z.skill));
                }
            }

        }
    }
}
