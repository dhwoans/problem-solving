package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1774 {

    private static double dis;
    private static boolean[] visited;
    private static int n;
    private static ArrayList<ArrayList<node>> arr;

    static class xy{
        private int x;
        private int y;

        private xy(int x,int y){
            this.x= x;
            this.y= y;
        }
    }
    static class node implements Comparable<node> {
        private int to;
        private Double cost;

        private node(int to,Double cost){
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(node o) {
            return this.cost.compareTo(o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dis = 0;

        arr = new ArrayList<>();
        for (int i = 0; i < n +1; i++) {
            arr.add(new ArrayList<>());
        }
        //좌표저장
        ArrayList<xy> xxyy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xxyy.add(new xy(x,y));
        }
        //간선만들기
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                xy from = xxyy.get(i);
                xy to = xxyy.get(j);
                double cost = Math.sqrt(Math.pow(Math.abs(from.x - to.x), 2) + Math.pow(Math.abs(from.y - to.y),2));
                arr.get(i+1).add(new node(j+1,cost));
                arr.get(j+1).add(new node(i+1,cost));
            }
        }
        //연결된 간선
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            for (int j = 0; j < arr.get(from).size(); j++) {
                if(arr.get(from).get(j).to==to){
                    arr.get(from).get(j).cost=0.00;
                  
                }
            }
            for (int j = 0; j < arr.get(to).size(); j++) {
                if(arr.get(to).get(j).to==from){
                    arr.get(to).get(j).cost=0.00;
                }
            }
        }
        prim();
        System.out.printf("%.2f", (double) Math.round(dis * 100) / 100);
    }

    private static void prim() {
        int cnt= 0;

        PriorityQueue<node> que = new PriorityQueue<>();
        que.add(new node(1,0.00));

        while (!que.isEmpty()){
            node z = que.poll();

            if(visited[z.to])continue;
            visited[z.to]=true;
            dis+=z.cost;

            if(++cnt==n){
                return;
            }
            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next = arr.get(z.to).get(i);
                if(visited[next.to])continue;
                que.add(next);
            }
        }
    }
}
