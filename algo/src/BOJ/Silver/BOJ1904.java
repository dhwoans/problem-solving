package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] dp = new Long[1000001];
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i < n + 1; i++) {
            long l = dp[i - 1] + dp[i - 2];
            dp[i] = l % 15746;
        }

        System.out.println(dp[n]);
    }
}
