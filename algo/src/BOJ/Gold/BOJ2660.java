package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2660 {

    private static ArrayList<ArrayList<Integer>> arr;
    private static boolean[] visited;
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<ArrayList<Integer>>();
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;

            if(from==-2 && to == -2){
                break;
            }
            arr.get(from).add(to);
            arr.get(to).add(from);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i]=true;
            depth[i]=bfs(i);
        }
        int min = Arrays.stream(depth).min().getAsInt();
        int count =0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth.length; i++) {
            if(min==depth[i]) {
                sb.append(i + 1).append(" ");
                count++;
            }
        }
        System.out.println((min-1)+" "+count);
        System.out.println(sb);


    }

    private static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int count =0;

        while(!que.isEmpty()){
            count++;
            int turn = que.size();
            for (int j = 0; j < turn; j++) {
                int temp = que.poll();

                for (int i = 0; i < arr.get(temp).size(); i++) {
                    int next = arr.get(temp).get(i);
                    if(visited[next])continue;
                    visited[next]=true;
                    que.add(next);
                }
            }
        }
        return count;
    }
}
