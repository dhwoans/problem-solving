package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17182 {
    static final int INF = 987654321;
    static int[][] map;
    static int n, sum;
    static boolean[] visit;
    static int min;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        //값 입력
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        visit = new boolean[n];
        visit[start]=true;
        min= Integer.MAX_VALUE;
        dfs(start, sum, 0);
        System.out.println(min);
    }

    static void dfs(int start, int sum, int cnt) {
        if (cnt == n-1) {
            min=Math.min(min,sum);
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i]=true;
                dfs(i,sum+map[start][i],cnt+1);
               visit[i]=false;
            }
        }


    }

}
