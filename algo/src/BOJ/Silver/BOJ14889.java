package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n  =Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit= new boolean[n];
        answer=Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int[] team1 = new int[n / 2];
        dfs(0,0);
        System.out.println(answer);
    }
    static void dfs(int start ,int cnt){
        if(cnt==n/2){
            cal();
            return;
        }
        for (int i = start; i < n; i++) {
            if(visit[i])continue;
            visit[i]=true;
            dfs(i+1,cnt+1);
            visit[i]=false;

        }
    }
    static void cal(){
        int team1=0;
        int team2=0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(visit[i]==true&&visit[j]==true){
                    team1+=map[i][j]+map[j][i];
                }
                if(visit[i]==false&&visit[j]==false){
                    team2+=map[i][j]+map[j][i];
                }
            }
        }
         answer=Math.min(Math.abs(team1-team2),answer);
    }
}
