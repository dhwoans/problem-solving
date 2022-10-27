package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.max;


public class BOJ4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            var n = Integer.parseInt(st.nextToken());
            var m = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
            //탈출
            if (n == 0 && m == 0.00) {
                System.out.println(sb);
                return;
            }
            //사탕정보
            int[] dp = new int[m+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int cost = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);

                //dp
                for (int j = cost; j < dp.length; j++) {
                    dp[j] = max(dp[j], dp[j - cost] + cal);
                }
            }
            sb.append(dp[m]).append("\n");
        }

    }
}
