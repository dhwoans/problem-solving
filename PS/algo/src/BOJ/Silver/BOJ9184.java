package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {

    private static int[][][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new int[101][101][101];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            sb.append(String.format("w(%s, %s, %s) = %s", a, b, c, w(a, b, c))).append("\n");

        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (arr[a + 50][b + 50][c + 50] != 0) {//계산한 적 있음
            return arr[a + 50][b + 50][c + 50];
        } else {// 계산 한적 없음
            if (a <= 0 || b <= 0 || c <= 0) arr[a + 50][b + 50][c + 50] = 1;
            else if (a > 20 || b > 20 || c > 20) arr[a + 50][b + 50][c + 50] = w(20, 20, 20);
            else if (a < b && b < c) arr[a + 50][b + 50][c + 50] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            else arr[a + 50][b + 50][c + 50] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            return arr[a + 50][b + 50][c + 50];
        }
    }
}
