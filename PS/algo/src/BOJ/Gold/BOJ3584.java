package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3584 {

    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            tree = new int[n + 1];
            //트리 정보
            for (int j = 0; j < n - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int pos = Integer.parseInt(st.nextToken());
                tree[pos] = parent;
            }
            //LCA 찾기
            boolean[] visited = new boolean[n + 1];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st1.nextToken());
            int node2 = Integer.parseInt(st1.nextToken());
            while(node1 != tree[node1]){
                visited[node1]=true;
                node1 = tree[node1];
            }
            while(node2 != tree[node2]){
                if(visited[node2]){
                    System.out.println(node2);
                    break;
                }
                visited[node2]=true;
                node2 = tree[node2];
            }
        }
    }
}
