package BOJ.Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ15591 {


    private static int n;
    private static int count;
    private static ArrayList<ArrayList<int[]>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        map = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n -1; i++) {
             st = new StringTokenizer(br.readLine());
             int from = Integer.parseInt(st.nextToken());
             int to = Integer.parseInt(st.nextToken());
             int cost = Integer.parseInt(st.nextToken());
             map.get(from).add(new int[]{to,cost});
             map.get(to).add(new int[]{from,cost});
        }

        for (int i = 0; i < q; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
               bfs(v,k);

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start,int cost) {
        boolean[] visited = new boolean[n + 1];
        LinkedList<int[]> que = new LinkedList<>();
        que.add(new int[]{start,987654321});
        visited[start]=true;
        while (!que.isEmpty()){
            int[] z = que.poll();

            for (int i = 0; i < map.get(z[0]).size(); i++) {
                int[] next = map.get(z[0]).get(i);
                if(visited[next[0]]||next[1]<cost)continue;
                visited[next[0]]=true;
                count++;
                que.add(next);
            }
        }
    }
}
