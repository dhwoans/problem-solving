package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ16398 {
    private static int n;

    private static class node{
        private int next;
        private int dis;

        public node(int next,int dis){
            this.next = next;
            this.dis = dis;
        }
    }
    private static int[][] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[n];
        long answer = prime();
        System.out.println(answer);


    }

    private static long prime() {
        int cnt = 0;
        long sum =0L;
        PriorityQueue<node> que = new PriorityQueue<>((o1, o2) -> o1.dis-o2.dis);

        que.add(new node(0,0));
        while (!que.isEmpty()) {
            node temp = que.poll();
            if(visited[temp.next])continue;
            visited[temp.next] = true;
            sum += temp.dis;
            cnt++;
            if(cnt==n){
                return sum;
            }
            for (int i = 0; i < arr[temp.next].length; i++) {
                int next = arr[temp.next][i];
                if(next==0)continue;
                que.add(new node(i,next));
            }

        }
        return -1;
    }
}
