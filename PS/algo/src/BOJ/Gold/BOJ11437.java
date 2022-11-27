package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11437 {


    private static List<ArrayList<Integer>> arr;
    private static node[] nodes;
    private static boolean[] visited;

    private static class node {
        int depth;
        int head;

        private node(int head, int depth) {
            this.depth = depth;
            this.head = head;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        nodes = new node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }
        //정보 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        nodes[1] = new node(0, 0);
        //깊이 부모 노드 탐색
        visited = new boolean[n + 1];
        visited[1]=true;
        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            //깊이가 다를때
            if (nodes[node1].depth > nodes[node2].depth) node1 = fineHead(node1, nodes[node2].depth);
            else if(nodes[node1].depth < nodes[node2].depth)node2 = fineHead(node2, nodes[node1].depth);

            //깊이가 같은데 조상이 다를때
            if (node1 == node2) sb.append(node2).append("\n");
            else sb.append(CommonAns(node1, node2)).append("\n");

        }
        System.out.println(sb);
    }

    private static int CommonAns(int node1, int node2) {
        while (node1 != node2) {
            node1 = nodes[node1].head;
            node2 = nodes[node2].head;
        }
        return node2;
    }

    private static int fineHead(int node, int end) {
        while (nodes[node].depth != end) {
            node = nodes[node].head;
        }
        return node;
    }

    private static void dfs(int root, int depth) {
        if (arr.get(root).size() == 0) {
            return;
        }
        for (int i = 0; i < arr.get(root).size(); i++) {
            if(visited[arr.get(root).get(i)])continue;
            visited[arr.get(root).get(i)]=true;
            nodes[arr.get(root).get(i)] = new node(root, depth + 1);
            dfs(arr.get(root).get(i), depth + 1);
            visited[arr.get(root).get(i)]=false;
        }

    }
}
