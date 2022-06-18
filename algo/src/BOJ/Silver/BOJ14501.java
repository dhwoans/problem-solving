package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];
        int[] dp = new int[n+1];
        // 정보 입력
        for (int i = 0; i < n; i++) {
            String[] str= br.readLine().split(" ");
            arr[0][i]=Integer.parseInt(str[0]);
            arr[1][i]=Integer.parseInt(str[1]);
        }

        for (int i = 0; i < n; i++) {
            if(i+arr[0][i]<dp.length){
                    dp[i+arr[0][i]]=Math.max(dp[i]+arr[1][i],dp[i+arr[0][i]]);
                    for (int k = i+arr[0][i]; k < dp.length; k++) {
                        dp[k]=Math.max(dp[i]+arr[1][i],dp[k]);

                    }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }
}
