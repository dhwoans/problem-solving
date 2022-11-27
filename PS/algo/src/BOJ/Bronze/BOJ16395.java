package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * no.16395
 * 파스칼의 삼각형
 */

public class BOJ16395 {//풀이중
    static int[][] memo;
    static int d(int n, int k ){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {

            }

        }

        return memo[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        memo = new int[n][k];
        System.out.println(d(n, k));
    }
}
