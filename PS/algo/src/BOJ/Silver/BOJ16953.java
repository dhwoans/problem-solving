package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16953 {

    private static int b;
    private static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        answer = -1;
        bfs(a);
        System.out.println(answer);
    }

    private static void bfs(int a) {
        PriorityQueue<long[]> que = new PriorityQueue<>((o1, o2) -> (int) (o1[1]-o2[1]));
        que.add(new long[]{a, 1});

        while (!que.isEmpty()) {
            long[] num = que.poll();

            if (num[0] > b) continue;
            if (num[0] == b) {
                answer = num[1];
                return;
            }
            que.add(new long[]{num[0] *10 + 1L, num[1] + 1L});
            que.add(new long[]{num[0] * 2L, num[1] + 1L});
        }
    }
}
