package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t  = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n  = Integer.parseInt(br.readLine());
            var que = new PriorityQueue<Long>();
            Long sum =0L;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                que.add(Long.parseLong(st.nextToken()));
            }
            while (que.size()!=1) {
                Long a = que.poll();
                Long b = que.poll();
                sum+=a+b;
                que.add(a+b);
            }
            System.out.println(sum);
        }

    }
}
