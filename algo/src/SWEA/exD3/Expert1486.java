package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert1486 {
    static int N;
    static int B;
    static int[] input;
    static boolean[] isSelect;
    static int min;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            input = new int[N];
            isSelect = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < input.length; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.println("#"+test_case+" "+(min-B));
        }
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            sum=0;
            for (int i = 0; i < input.length; i++) {
                if(isSelect[i])continue;
                sum+=input[i];
            }
            if(sum>=B){
                min=Math.min(min,sum);
            }
            return;
        }

        isSelect[cnt] = true;
        dfs(cnt + 1);

        isSelect[cnt] = false;
        dfs(cnt + 1);

    }
}


