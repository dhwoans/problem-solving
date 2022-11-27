package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+100];

        // 정보 입력
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //비용
            info[i][0]=Integer.parseInt(st.nextToken());
            //고객
            info[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,987654321);
        dp[0]=0;
        // 계산
        for (int i = 0; i < N; i++) {
            for (int j = info[i][1]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j],dp[j-info[i][1]]+info[i][0]);

            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = C; i < dp.length ; i++) {
            answer = Math.min(dp[i],answer);
        }
        System.out.println(answer);



    }
}
