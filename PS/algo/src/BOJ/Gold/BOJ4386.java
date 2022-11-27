package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4386 {

    private static int n;
    private static ArrayList<ArrayList<Double>> arr;

    private static class xxyy{
        double x;
        double y;

        xxyy(double x,double y){
            this.x = x;
            this.y = y;
        }
    }
    private static class node implements Comparable<node> {
        int to;
        double val;

        node(int to,double val){
            this.val =val;
            this.to=to;
        }

        @Override
        public int compareTo(node o) {
            return (int) (this.val-o.val);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ArrayList<xxyy> star = new ArrayList<>();

        //별자리 저장
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            star.add(new xxyy(x,y));
        }

        //거리 구하기
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < star.size(); i++) {
            for (int j = 0; j < star.size(); j++) {
                double xx = star.get(i).x-star.get(j).x;
                double yy = star.get(i).y-star.get(j).y;
                double dis = Math.sqrt(xx*xx+yy*yy);
                arr.get(i).add(dis);
            }
        }

        double answer = prim();
        System.out.printf("%.2f",answer);
    }

    private static double prim() {
        boolean[] visited = new boolean[n];
        PriorityQueue<node> que = new PriorityQueue<>();
        int cnt = 0;
        double val =0;

        que.add(new node(0,0));

        while(!que.isEmpty()){
            node z = que.poll();
            if(visited[z.to])continue;
            visited[z.to]=true;
            val+=z.val;
            cnt++;

            if(cnt==n){
                return val;
            }

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                if(visited[i])continue;
                que.add(new node(i,arr.get(z.to).get(i)));
            }
        }
        return -1;
    }
}
