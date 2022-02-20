package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1167 {

    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        map = new int[v + 1][v + 1];
        visit = new boolean[v + 1][v + 1];

        //간선정보 입력
        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true){
                int to =Integer.parseInt(st.nextToken());
                if(to==-1)break;
                int cost = Integer.parseInt(st.nextToken());
                
                map[from][to] = Math.max(map[from][to],cost);
            }
        }
        Dfs();
    }

    private static void Dfs() {

    }
}
