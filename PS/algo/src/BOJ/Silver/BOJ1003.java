package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    static long[][] memo;//

    static void count(int N) {
        memo = new long[40 + 1][2];
        memo[0][0]=1;
        memo[0][1]=0;
        memo[1][1]=1;
        memo[1][0]=0;
        memo[2][0] = 1;
        memo[2][1] = 1;
        memo[3][0] = 1;
        memo[3][1] = 2;

        for (int i = 3; i <= 40; i++) {
            for (int j = 0; j < 2; j++) {
                memo[i][j] = memo[i - 2][j] + memo[i - 1][j];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count(0);
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(memo[n][0] + " " + memo[n][1]);
        }
    }
}
