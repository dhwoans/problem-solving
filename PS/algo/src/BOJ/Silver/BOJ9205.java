package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9205 {

    private static ArrayList<ArrayList<xy>> arr;
    private static ArrayList<xy> node;
    private static boolean[] visited;

    private static class xy{
        int x;
        int y;
        int num;

        private xy(int x,int y,int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            node = new ArrayList<>();
            visited = new boolean[n + 2];

            for (int j = 0; j < n+2; j++) {
                arr.add(new ArrayList<>());
            }
            //입력받기
            for (int j = 0; j < n + 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken() );
                int y = Integer.parseInt(st.nextToken());

                node.add(new xy(x,y,j));
            }

            //간선체크
            for (int j = 0; j < node.size(); j++) {
                for (int k = 0; k < node.size(); k++) {
                    if(j==k)continue;
                    if(Math.abs(node.get(j).x-node.get(k).x)+Math.abs(node.get(j).y-node.get(k).y)<=1000){
                        arr.get(j).add(node.get(k));
                    }
                }
            }
            bfs();
            if(visited[n+1]){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
    }

    private static void bfs() {
        Queue<xy> que = new LinkedList<>();
        que.add(node.get(0));
        visited[0]=true;

        while(!que.isEmpty()){
            xy z = que.poll();

            for (int i = 0; i < arr.get(z.num).size(); i++) {
                xy next = arr.get(z.num).get(i);
                if(visited[next.num])continue;
                visited[next.num]=true;
                que.add(next);
            }
        }
    }
}
