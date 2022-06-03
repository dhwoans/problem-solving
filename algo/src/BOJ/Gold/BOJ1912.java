package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < dp.length; i++) {
            sum+=arr[i];
            dp[i]=Math.max(arr[i],sum);
            if(arr[i]>sum){
                sum=arr[i];

            }
        }
        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }
}
