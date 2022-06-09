package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549 {

    private static int[] arr;
    private static int[] visited;
    private static int n;
    private static int k;

    private static class info implements Comparable<info>{
        int pos;
        int turn;

        info(int pos,int turn){
            this.pos = pos;
            this.turn = turn;
        }

        @Override
        public int compareTo(info o) {
            return this.turn-o.turn;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        visited = new int[100001];
        Arrays.fill(visited,987654321);
        bfs();
        System.out.println(visited[k]);
    }

    private static void bfs() {
        PriorityQueue<info> que = new PriorityQueue<>();
        que.add(new info(n,0));

        while(!que.isEmpty()){
            info z = que.poll();

            if(visited[z.pos]<z.turn)continue;
            visited[z.pos]=z.turn;

            if(z.pos*2<=100000){
                que.add(new info(z.pos*2,z.turn));

            }
            if(z.pos+1<=100000){
                que.add(new info(z.pos+1,z.turn+1));
            }
            if(z.pos-1>=0){
                que.add(new info(z.pos-1,z.turn+1));
            }

        }
    }
}
