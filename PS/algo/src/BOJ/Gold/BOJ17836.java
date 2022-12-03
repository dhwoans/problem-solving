package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

public class BOJ17836 {

    private static int[][] arr;
    private static int dis;
    private static int n;
    private static int m;
    private static int min = Integer.MAX_VALUE;
    private static boolean[][] visited;
    private static final int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = temp[0];
        m = temp[1];
        dis = temp[2];
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited[0][0]=true;
        bfs(0,0);
        if(min==Integer.MAX_VALUE) System.out.println("Fail");
        else System.out.println(min);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y,0});
        while(!que.isEmpty()){
            int[] temp = que.poll();

            if(temp[0]==n-1 && temp[1] == m-1){
                min = min(min,temp[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx=  temp[0] + dir[i][0];
                int ny = temp[1] + dir[i][1];

                if(nx<0||ny<0||nx>=n||ny>=m)continue;
                if(arr[nx][ny]==1)continue;
                if(visited[nx][ny])continue;
                if(temp[2]>dis)continue;
                if(arr[nx][ny]==2&& temp[2]+1+n-1-nx+m-1-ny<=dis){
                    min = min(min,temp[2]+1+n-1-nx+m-1-ny);
                }
                visited[nx][ny]=true;
                que.add(new int[]{nx,ny,temp[2]+1});
            }
        }
    }
}
