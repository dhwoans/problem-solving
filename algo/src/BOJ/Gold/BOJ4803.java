package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ4803 {

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> node;
    private static int count;
    private static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        isCycle = false;
        StringBuilder sb = new StringBuilder();
        while (true) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            node = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                node.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                node.get(from).add(to);
                node.get(to).add(from);

            }
            visited = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                isCycle=false;
                if (visited[i]) continue;
                visited[i] = true;
                dfs(i,0,i);
                if(!isCycle){
                    count++;
                }
            }
            sb.append("Case ").append(num++).append(": ");
            if (count == 0) sb.append("No trees.").append("\n");
            else if (count == 1) sb.append("There is one tree.").append("\n");
            else sb.append("A forest of ").append(count).append(" trees.").append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start,int previous, int i) {
        for (int j = 0; j < node.get(i).size(); j++) {
            int next = node.get(i).get(j);
            if (previous!=next && visited[next]) {
                isCycle= true;
            }
            if (visited[next]) continue;
            visited[next] = true;
            dfs(start,i, next);
        }
    }
}
