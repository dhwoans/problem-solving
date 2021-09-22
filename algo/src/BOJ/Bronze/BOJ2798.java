package BOJ.Bronze;

import java.util.Scanner;

public class BOJ2798 {
    static int r = 3;
    static int[] arr;
    static int[] input;
    static int limit;
    static boolean isSelect[];
    static int max=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        limit = sc.nextInt();
        input = new int[N];
        isSelect = new boolean[N];

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int cnt, int start, int sum) {
        if (cnt == r) {

            if (sum <= limit) {

                max = Math.max(max, sum);
            }

            return;
        }
        for (int i = start; i < input.length; i++) {
            if (isSelect[i]) continue;

            isSelect[i] = true;
            dfs(cnt + 1, i + 1, sum += input[i]);
            isSelect[i] = false;
            sum -= input[i];


        }
    }
}
