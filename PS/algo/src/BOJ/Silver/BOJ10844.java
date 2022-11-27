package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10844 {

    private static long[][] dp;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        count = 0;
        dp = new long[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i]=1;
        }
//        for (int i = 1; i < 10; i++) {
//            brute(i,1,n);
//        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                dynamic(i,j);
            }
        }

        long answer = Arrays.stream(dp[n-1]).sum()-dp[n-1][0];
        System.out.println(answer%1000000000);
//        System.out.println(count);
    }

//    private static void brute(int start,int cnt,int end) {
//        if (cnt == end) {
//            count++;
//            return;
//        }
//        if(start+1<10)brute(start+1,cnt+1,end);
//        if(start-1>=0)brute(start-1,cnt+1,end);
//    }
    private static long dynamic(int n , int num){
        if(dp[n][num]!=0) return dp[n][num]%1000000000;
        if(num==0) dp[n][0]= dynamic(n-1,1);
        else if(num==9)  dp[n][9]=dynamic(n-1,8);
        else  dp[n][num]=dynamic(n-1,num-1)+dynamic(n-1,num+1);
        return dp[n][num]%1000000000;
    }
}
