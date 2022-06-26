package BOJ.Gold;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1368 {

    private static int n;
    private static int[] arr;
    private static ArrayList<ArrayList<info>> map;

    private static class info implements Comparable<info>{
        int to;
        int cost;

        private info(int to,int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(info o) {
            return this.cost-o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        map = new ArrayList<>();
        int answer =Integer.MAX_VALUE;

        //노드
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        //우물비용
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        //간선정보
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if(i==j){
                    String dumy = st.nextToken();
                    continue;
                }

                map.get(i).add(new info(j,Integer.parseInt(st.nextToken())));
            }

        }

        for (int i = 0; i < arr.length; i++) {

            answer = Math.min(answer,prim(i));
        }
        System.out.println(answer);

    }

    private static int prim(int to) {
        int[] copy = Arrays.copyOf(arr,arr.length);
        PriorityQueue<info> que = new PriorityQueue<>();
        que.offer(new info(to,0));
        boolean[] visited = new boolean[n];
        int cnt =0;

        while (!que.isEmpty()){
            info temp = que.poll();
            if(visited[temp.to])continue;
            visited[temp.to]=true;
            cnt++;

            if(cnt==n){
                return Arrays.stream(copy).sum();
            }
            for (int i = 0; i < map.get(temp.to).size(); i++) {
                info next = map.get(temp.to).get(i);
                if(visited[i])continue;
                if(copy[next.to]<next.cost) continue;
                copy[next.to]=next.cost;
                que.add(next);
            }
        }
        return Arrays.stream(copy).sum();
    }
}
