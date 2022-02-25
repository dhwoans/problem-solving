package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    private static int[] arr;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0]= arr[0];
        dp[1]= arr[1];

        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(run(n));

    }

    private static int run(int num) {
        if(dp[num] == null) {
            dp[num] = Math.max(run(num - 2), run(num - 3) + arr[num - 1]) + arr[num];
        }

        return dp[num];
    }



}
