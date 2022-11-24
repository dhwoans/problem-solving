package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {

    private static ArrayList<ArrayList<Node>> arr;
    private static boolean[] visited;
    private static int research_node;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();


        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        //정보받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Node> info = arr.get(num);
            boolean flag = true;
            int to = 0;
            int cost = 0;
            while (true) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1) break;
                if (flag) {
                    to = temp;
                    flag = false;
                } else {
                    cost = temp;
                    info.add(new Node(to, cost));
                    flag = true;
                }
            }
        }
        visited = new boolean[n + 1];
        research_node = 0;
        answer = 0;
        visited[1]=true;
        dfs(1, 0);
        visited = new boolean[n + 1];
        answer =0;
        visited[research_node]=true;
        dfs(research_node,0);
        System.out.println(answer);

    }

    private static void dfs(int next, int sum) {
        for (int i = 0; i < arr.get(next).size(); i++) {
            Node temp = arr.get(next).get(i);
            if(!visited[temp.to]){
                visited[temp.to]=true;
                dfs(temp.to,sum+temp.value);
                visited[temp.to]=false;
            }
            if(sum>answer){
                answer =sum;
                research_node = next;

            }
        }
    }
}
