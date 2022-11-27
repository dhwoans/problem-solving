package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1743 {

    private static int[][] map;
    private static boolean[][] visited;

    private static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1},};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer =0;
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        //맵생성
        map = new int[r][c];
        visited = new boolean[r][c];

        //쓰레기 표시
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            map[x][y]=1;
        }

        //BFS
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==1&&!visited[i][j]){
                    visited[i][j]=true;
                    answer = Math.max(answer, bfs(i,j));
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int x,int y) {
        int count =1;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});

        while(!que.isEmpty()){
            int[] temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dir[i][0];
                int ny = temp[1] + dir[i][1];

                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)continue;
                if(visited[nx][ny]||map[nx][ny]==0)continue;
                visited[nx][ny]=true;
                que.add(new int[]{nx,ny});
                count++;
            }
        }
        return count;
    }
}
