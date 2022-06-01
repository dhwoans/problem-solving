package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] coin = new int[n];
            //동전 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < coin.length; j++) {
                coin[j]=Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int[] dp = new int[target+1];

            for (int value : coin) {
                if(dp.length<=value)continue;// 만들어야할 금액이 가지고 있는 동전 금액 보다 작을 경우
                dp[value] += 1;
                for (int k = value; k < dp.length; k++) {
                    dp[k] += dp[k - value];
                }
            }
            System.out.println(dp[dp.length-1]);
        }
    }
}
