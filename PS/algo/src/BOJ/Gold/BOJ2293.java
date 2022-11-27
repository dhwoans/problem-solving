package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {

    private static int k;
    private static int n;
    private static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coin = new int[n+1];
        int[] dp = new int[k+1];

        //정보입력
        for (int i = 1; i < coin.length; i++) {
            coin[i]=Integer.parseInt(br.readLine());
        }
        dp[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j < dp.length; j++) {
                dp[j]+=dp[j-coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
