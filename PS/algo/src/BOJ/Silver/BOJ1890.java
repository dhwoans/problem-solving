package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1890 {

    private static int[][] map;
    private static int count;
    private static long[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new long[n][n];
        //맵만들기
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
//        visited[0][0]=1L;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i==n-1&&j==n-1&&map[i][j]==0)break;
//                int nx = i+map[i][j];
//                int ny = j+map[i][j];
//
//                if(nx<n)visited[nx][j]+=visited[i][j];
//                if(ny<n)visited[i][ny]+=visited[i][j];
//            }
//        }
        System.out.println(visited[0][0]);
        
    }

    private static long dfs(int x,int y) {
        if(x==visited.length-1&&y==visited[0].length-1) {
            //목적지
            visited[x][y]+=1;
             return 1;
        }else if(map[x][y]==0) {
            //점프 할수 없는 경우
            return 0;
        }
        //방문한적 있음
        if(visited[x][y]!=0){
            return visited[x][y];
        }
            int nx = x+map[x][y];
            int ny = y+map[x][y];

            if(nx<visited.length){
                visited[x][y]+=dfs(nx,y);

            }
            if(ny<visited.length) {
                visited[x][y]+= dfs(x,ny);
            }

        return visited[x][y];

    }

}
