package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, 1);
        dp[1] = 0;

        for (int i = 2; i < 1300; i++) {
             for (int j = 2; j < 1_000_001; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    if (sum > 1_000_000) break;
                    sum += k;
                }
                if (sum < 1_000_001) dp[sum]++;

            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            System.out.println(dp[n]);
        }
    }
}
