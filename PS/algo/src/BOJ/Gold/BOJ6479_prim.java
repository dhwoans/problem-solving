package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6479_prim {

    private static ArrayList<ArrayList<info>> arr;
    private static int m;
    private static int n;

    private static class info implements Comparable<info> {
        int to;
        int cost;

        private info(int to,int cost){
            this.to = to;
            this.cost =cost;
        }

        @Override
        public int compareTo(info o) {
            return this.cost-o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0&&n==0){
                break;
            }
            int answer =0;
            arr = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                arr.add(new ArrayList<>());
            }
            //간선 정보
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                arr.get(from).add(new info(to,cost));
                arr.get(to).add(new info(from,cost));

                answer += cost;
            }
            System.out.println(answer-prim());
        }
    }

    private static int prim() {
        PriorityQueue<info> que = new PriorityQueue<>();
        que.add(new info(0,0));
        boolean[] visited = new boolean[m];
        int cnt =0;
        int sum =0;

        while (!que.isEmpty()){
            info temp  = que.poll();

            if(visited[temp.to])continue;
            visited[temp.to]= true;
            cnt++;
            sum+=temp.cost;
            if(cnt==m){
                return sum;
            }
            for (int i = 0; i < arr.get(temp.to).size(); i++) {
                info next = arr.get(temp.to).get(i);
                if(visited[next.to])continue;
                que.add(next);
            }
        }
        return sum;
    }
}
