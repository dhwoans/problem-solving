package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        int[][] dp = new int[k+1][t+1];

        for (int i = 0; i < k; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr.add(temp);
        }

        arr.sort((o1, o2) -> o1[0]-o2[0]);

        for (int i = 1; i < dp.length; i++) {
            dp[i-1][0] = 1;
            for (int num = 0; num <= arr.get(i-1)[1]; num++) {
                for (int j = arr.get(i-1)[0]*num; j < dp[i].length; j++) {
                    dp[i][j]+=dp[i-1][j-arr.get(i-1)[0]*num];

                }
            }
        }
        System.out.println(dp[k][t]);
    }
}
