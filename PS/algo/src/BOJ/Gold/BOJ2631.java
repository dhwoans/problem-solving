package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        //입력받기
        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        //LIS
        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }
        final int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(n-max);
    }
}
