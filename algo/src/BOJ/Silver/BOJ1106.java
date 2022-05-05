package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][1001];


        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0]=Integer.parseInt(st.nextToken());
            info[i][1]=Integer.parseInt(st.nextToken());
        }
        Collections.sort(Arrays.asList(info),(o1, o2) -> o1[1]-o2[1]);

        for (int j = 0; j < dp[0].length; j++) {
            if(j>=info[0][1]){
                dp[0][j]= info[0][0]+dp[0][j-info[0][1]];
            }
            if(j%info[0][1]==0){
                dp[0][j] = Math.min(info[0][0] * (j / info[0][1]),dp[0][j]);
                }
            }



        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j>=info[i][1]){
                    dp[i][j]= Math.min(info[i][0]+dp[i][j-info[i][1]],dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
                if(j%info[i][1]==0){
                    dp[i][j]= Math.min(info[i][0]*(j/info[i][1]),dp[i][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = C; i < dp[0].length; i++) {
            answer = Math.min(answer, dp[N-1][i]);
        }
        System.out.println(answer);
    }
}
