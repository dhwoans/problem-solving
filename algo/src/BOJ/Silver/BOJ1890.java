package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1890 {

    private static int[][] map;
    private static boolean[][] visited;

    private static class xy{
        int x;
        int y;
        int count;

        private xy(int x,int y,int count){
            this.x =x;
            this.y =y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        //맵만들기
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer =bfs();
        System.out.println(answer);

    }

    private static int bfs() {
        LinkedList<xy> que = new LinkedList<>();
        que.add(new xy(0,0,0));
        while(!que.isEmpty()){
            xy z = que.poll();

            if(z.x==map.length-1&&z.y==map[0].length-1){
                return z.count;
            }

            int nx = z.x+map[z.x][z.y];
            int ny = z.y+map[z.x][z.y];
            if(nx>=0&&nx<map.length&&!visited[nx][z.y]){
                visited[nx][z.y]=true;
                que.add(new xy(nx,z.y,z.count+1));
            }
            if(ny>=0&&ny<map[0].length&&!visited[z.x][ny]){
                visited[z.x][ny]=true;
                que.add(new xy(z.x,ny,z.count+1));
            }
        }
        return -1;
    }
}
