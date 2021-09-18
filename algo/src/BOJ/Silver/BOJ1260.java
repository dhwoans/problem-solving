package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int N,M,start;
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        start = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            int v1 = Integer.parseInt(br.readLine());
            int v2 = Integer.parseInt(br.readLine());

            map[v1][v2]=1;
            map[v2][v1]=1;
        }
        BFS(start);
    }
    static  void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v]=true;

       while(!q.isEmpty()){

       }
    }
}
