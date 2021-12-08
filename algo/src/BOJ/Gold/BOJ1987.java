package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ_1987_알파벳
 * @date : 2021. 12. 07.
 * @language : JAVA
 * @classification : dfs
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ1987 {
    static char[][] map;
    static boolean[] visit;
    static int R,C;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //값 입력
        map= new char[R][C];
        for (int i = 0; i < map.length; i++) {
            String str= br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        visit = new boolean[26];
        max=0;
        visit[map[0][0]-'A']=true;
        Dfs(1,0,0);
        System.out.println(max);
    }

    private static void Dfs(int count,int r,int c) {
        max=Math.max(max,count);
        for (int i = 0; i < 4; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];

            if(nr<0||nc<0||nr>=R||nc>=C)continue;
            if(!visit[map[nr][nc]-'A']){
                visit[map[nr][nc]-'A']=true;
                Dfs(count+1,nr,nc);
                visit[map[nr][nc]-'A']=false;
            }
        }
    }
}
