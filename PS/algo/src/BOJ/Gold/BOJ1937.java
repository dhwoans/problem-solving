package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class BOJ1937 {
    private static int[][] map;
    private static int[][] count;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = new int[n][n];

        for (int i = 0; i < n; i++) {
           Arrays.fill(count[i],-1);
        }
        //대나무 수
        for (int i = 0; i < n; i++) {
            map[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(count[i][j]==-1) count[i][j]=dfs(i, j);
            }
        }
        int answer = Arrays.stream(count).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println(answer);
    }

    private static int dfs(int i, int j) {
        if(count[i][j]!=-1){
            return count[i][j];
        }else{
            count[i][j]=1;
            for (int k = 0; k < 4; k++) {
                int nx = i +dir[k][0];
                int ny = j +dir[k][1];

                if(nx<0||ny<0||nx>=map.length||ny>=map.length)continue;
                if(map[i][j]<map[nx][ny]){
                    count[i][j] = Math.max(count[i][j], dfs(nx, ny) + 1);
                }
            }
        }
       return count[i][j];
    }
}
