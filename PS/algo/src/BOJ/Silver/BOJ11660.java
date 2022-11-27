package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < map.length; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                sum += Integer.parseInt(st.nextToken());
                map[i][j] = sum;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int answer = 0;
            for (int j = x1; j <= x2; j++) {
                if (y1 == 0) {
                    answer += map[j][y2];
                } else {
                    answer += map[j][y2] - map[j][y1 - 1];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        sb.setLength(0);
    }
}