package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BOJ2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];
        //입력
        for (int i = 0; i < n; i++) {
            arr[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        //첫번째 기준으로 정렬
        Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);
        //LIS
        for (int i = 0; i < n; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(arr[i][1]>arr[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max =Arrays.stream(dp).max().getAsInt();
        System.out.println(n-max);
    }
}
