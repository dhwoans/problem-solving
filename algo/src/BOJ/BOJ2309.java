package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    static int r, n;
    static int arr[], input[];
    static boolean isSelect[];
    static int count=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = 9;
        r = 7;
        input = new int[n];
        isSelect = new boolean[n];
        arr = new int[r];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0, 0);
    }

    static void dfs(int cnt, int start, int sum) {
        if (cnt == r) {
            if (sum == 100&&count==1) {
                Arrays.sort(arr);
                for (int i : arr) {
                    System.out.println(i);


                }
                count++;

            }
            return;
        }
        for (int i = start; i < input.length; i++) {
            if (isSelect[i]) continue;
            arr[cnt] = input[i];
            isSelect[i] = true;
            dfs(cnt + 1, i + 1, sum += input[i]);
            isSelect[i] = false;
            sum -= input[i];
        }
    }
}
