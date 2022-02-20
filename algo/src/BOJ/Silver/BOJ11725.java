package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {


    private static int v;
    private static int[] visit;
    private static StringBuilder sb;
    private static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        visit = new int[v+1];

        for (int i = 0; i <= v; i++) {
            map.add(new ArrayList<>());
        }
        //간선정보입력
        for (int i = 0; i < v - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map.get(from).add(to);
            map.get(to).add(from);

        }
        sb = new StringBuilder();
        dfs(1);
        for (int i = 2; i < visit.length; i++) {
            System.out.println(visit[i]);
        }
    }

    private static void dfs(int s) {
        for (int i = 0; i < map.get(s).size(); i++) {
            if(visit[map.get(s).get(i)]==0){
                visit[map.get(s).get(i)]=s;
                dfs(map.get(s).get(i));
            }

        }
    }
}
