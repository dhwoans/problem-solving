
package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1504_ployd {

    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //행렬 생성
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if(i==j)continue;
                map[i][j]=INF;
            }
        }

        //값 입력
        for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from =Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                map[from][to]=cost;
                map[to][from]=cost;
            }

        //플로이드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        //반드시 거쳐야 하는 정점
        st=new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int route1 = map[1][node1] + map[node1][node2] + map[node2][N];
        int route2 = map[1][node2] + map[node2][node1] + map[node1][N];
        int answer = Math.min(route1,route2);

        if(map[1][node1]==INF|| map[node1][node2]==INF|| map[node2][N]==INF||map[node2][node1]==INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }
}
