package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        //정보입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i]= 987654321;
        }
        dp[0]=0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            while (temp > 0) {
                if(i+temp>=arr.length){
                    temp=arr.length-i-1;
                }
                dp[i+temp]= Math.min(dp[i]+1,dp[i+temp]);
                temp--;
            }
        }
        if(dp[n-1]>=987654321){
            System.out.println(-1);
        }else{
            System.out.println(dp[n-1]);
        }
    }
}
