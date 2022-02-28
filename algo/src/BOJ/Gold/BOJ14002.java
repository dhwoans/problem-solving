package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ14002
 * @date : 2022-02-28
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ14002 {

    private static int[] arr;
    private static int[] dp;
    private static ArrayList<int[]> order;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        order = new ArrayList<>();

        //정보 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            order.add(new int[]{-1});
        }

        for (int i = 0; i < arr.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[j]< arr[i]){
                    if(dp[i]< dp[j]+1){
                        dp[i]= dp[j]+1;
                        order.get(i)[0]=j;
                    }

                }
            }
        }

        int result =  0;
        int start =0;
        for (int i = 0; i < dp.length; i++) {
            if(result< dp[i]){
                start =i;
                result = dp[i];
            }
        }

        sb = new StringBuilder();
        dfs(start);
        sb.append(arr[start]).append(" ");
        System.out.println(result);
        System.out.println(sb);
        
    }

    private static void dfs(int next) {
       if(order.get(next)[0]==-1){
           return;
       }
       dfs(order.get(next)[0]);
       sb.append(arr[order.get(next)[0]]).append(" ");
    }
}
