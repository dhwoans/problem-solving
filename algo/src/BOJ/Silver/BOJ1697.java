package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ1697
 * @date : 2021-12-30
 * @language : JAVA
 * @classification : bfs
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        visit[N] = 0;

        while (!que.isEmpty()) {
            int z = que.poll();

            if (z == K) {
                System.out.println(visit[z]);
                break;
            }
            if (z - 1 >= 0 && visit[z - 1] == 0) {
                visit[z - 1] = visit[z] + 1;
                que.add(z - 1);
            }
            if (z + 1 <= 100000 && visit[z + 1] == 0) {
                visit[z + 1] = visit[z] + 1;
                que.add(z + 1);
            }
            if (2 * z <= 100000 && visit[2 * z] == 0) {
                visit[2 * z] = visit[z] + 1;
                que.add(2 * z);
            }


        }

    }
}
