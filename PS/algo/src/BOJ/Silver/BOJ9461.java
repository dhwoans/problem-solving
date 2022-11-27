package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp = new long[101];
        dp[1]=1L;
        dp[2]=1L;
        dp[3]=1L;


        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(permutation(n)).append("\n");
        }
        System.out.println(sb);
    }

    private static long permutation(int n) {
        if(dp[n]!=0L){
            return dp[n];
        }else{
            return dp[n]=permutation(n-3)+permutation(n-2);
        }
    }
}
