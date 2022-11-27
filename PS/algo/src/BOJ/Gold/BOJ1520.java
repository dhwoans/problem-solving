package BOJ.Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {

    private static int[][] map;
    private static long[][] visited;
    private static int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new long[n][m];

        //맵 생성
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                visited[i][j] = -1;
            }
        }
        dfs(0,0);
        System.out.println(visited[0][0]);
    }

    private static long dfs(int x,int y) {
        if(x==map.length-1&&y==map[0].length-1){
            visited[x][y]+=1;
            return 1;
        }
        //방문한적 있다면
        if(visited[x][y]!=-1){
            return visited[x][y];
        }else{
            visited[x][y]=0;
            for (int i = 0; i < 4; i++) {
                int nx = x+dir[i][0];
                int ny = y+dir[i][1];

                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)continue;
                if(map[x][y]>map[nx][ny]){
                    visited[x][y]+=dfs(nx,ny);
                }

            }
        }
        return visited[x][y];
    }
}
