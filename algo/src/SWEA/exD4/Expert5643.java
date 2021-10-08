package SWEA.exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/**
 * 5643.키 순서
 * <p>
 * 유향 그래프
 * <p>
 * dfs로 자신보다 위,아래 몇명 있는지 
 * <p>
 * 배열 만들어서 기록
 */

public class Expert5643 {
    static int N, M, count;
    static int[][] tall, tiny;
    static int[] up, down;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            tall = new int[N + 1][N + 1];
            tiny = new int[N + 1][N + 1];
            up = new int[N + 1];
            down = new int[N + 1];

            //값 담기
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                tall[from][to] = 1;
                tiny[to][from] = 1;

            }


            for (int i = 1; i < N + 1; i++) {
                count = 0;
                visit= new boolean[N+1];
                up[i] = dfs(i, tall);
                count = 0;
                visit= new boolean[N+1];
                down[i] = dfs(i, tiny);
            }
            int answer = 0;
            for (int i = 1; i < up.length; i++) {
                if (up[i] + down[i] == N - 1) answer++;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }


    private static int dfs(int cnt, int[][] arr) {

        for (int i = 1; i < N + 1; i++) {
            if (arr[cnt][i] == 1) {
                if(visit[i]){continue;}
                visit[i]=true;
                count++;
                dfs(i, arr);
            }
        }
        return count;
    }
}
