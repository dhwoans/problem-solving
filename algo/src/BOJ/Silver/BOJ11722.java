package BOJ.Silver;

import javax.management.MXBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ11722
 * @date : 2022-02-28
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //정보 입력
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length ; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int result =1;
        for (int i : dp) {
            result = Math.max(result,i);
        }

        System.out.println(result);



    }
}
