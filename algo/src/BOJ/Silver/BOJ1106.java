package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ1106
 * @date : 2021-12-22
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cost = new int[N + 1];
        int[] customer = new int[N + 1];
        int[][] map = new int[N + 1][C + 1];

        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int cu = Integer.parseInt(st.nextToken());

            cost[i] = c;
            customer[i] = cu;
        }


        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if (customer[i] <= j) {
                        map[i][j] = Math.max(map[i - 1][j], cost[i] + map[i][j - customer[i]]);
                } else {
                    map[i][j] = map[i - 1][j];
                }
            }
        }

        System.out.println(map[N][C]);
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
