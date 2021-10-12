package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] ints = new int[n + 2];
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ints[j] = x + y;
            }
            boolean flag = true;
            for (int j = 0; j < ints.length - 1; j++) {
                if (Math.abs(ints[j] - ints[j + 1]) > 1000) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }
}
