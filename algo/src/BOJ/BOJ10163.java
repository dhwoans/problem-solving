package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = "4\n" +
                "0 2 10 10\n" +
                "7 9 8 4\n" +
                "8 4 10 6\n" +
                "6 0 12 10";
        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        int[][] map = new int[1001][1001];
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = x; j < r+x; j++) {
                for (int k = y; k < c+y; k++) {
                    map[k][j]=i;
                }
            }
        }

        for (int i = 1; i <= T; i++) {
            int count =0;
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map.length; k++) {
                    if(map[j][k]==i){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

}
