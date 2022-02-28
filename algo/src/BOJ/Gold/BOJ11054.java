package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] reverseDP = new int[n];

        //정보 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            reverseDP[i]=1;
            for (int j = arr.length-1; j >i ; j--) {
                if(arr[i]>arr[j]){
                    reverseDP[i]=Math.max(reverseDP[i],reverseDP[j]+1);
                }
            }
        }
        int result =0;
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, dp[i]+reverseDP[i]);
        }
        System.out.println(result-1);
    }
}
