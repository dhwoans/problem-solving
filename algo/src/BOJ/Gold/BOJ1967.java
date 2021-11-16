package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드
 */
public class BOJ1967 {//풀이중 --시간초과
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int map[][]=new int[n][n];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(i==j)continue;
                map[i][j]=INF;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            map[from][to]=cost;
            map[to][from]=cost;
        }

        //플로이드
        for (int k = 0; k < map.length; k++) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int[] ints : map) {
            for (int i : ints) {
               if(i==INF)continue;
               max =Math.max(max,i);
            }
        }
            System.out.println(max);
    }
}
