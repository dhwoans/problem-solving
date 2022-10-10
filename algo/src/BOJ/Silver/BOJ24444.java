package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ24444 {

    private static boolean[] visited;
    private static int[] answer;
    private static ArrayList<PriorityQueue<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        arr = new ArrayList<>();
        visited = new boolean[n];
        answer = new int[n];

        //노드추가
        for (int i = 0; i < n; i++) {
            arr.add(new PriorityQueue<>());
        }

        //간선추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken())-1;
            int to  = Integer.parseInt(st.nextToken())-1;

            arr.get(from).add(to);
            arr.get(to).add(from);
        }
        bfs(r);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int count =1;
        answer[start]=count;
        que.add(start);
        visited[start]= true;
        while(!que.isEmpty()){
            int temp = que.poll();

            while(!arr.get(temp).isEmpty()) {
                int next = arr.get(temp).poll();
                if(visited[next])continue;
                visited[next]=true;
                answer[next]=++count;
                que.add(next);
            }
        }

    }
}
