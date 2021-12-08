package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_6064_카잉달력
 * @date : 2021. 12. 07.
 * @language : JAVA
 * @classification : math
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description 최소공배수
 * map에 담으면 메모리 초과
 **/
public class BOJ6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int answer = -1;

            for (int j = x; j < M * N; j += M) {
                if (j % N == y) {
                    answer = j + 1;

                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
