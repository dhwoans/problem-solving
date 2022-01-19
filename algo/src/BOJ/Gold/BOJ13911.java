package BOJ.Gold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ13911
 * @date : 2022-01-19
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ13911 {
    static ArrayList<ArrayList<node>> arr;
    static int[] visit;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> mac = new HashMap<>();
        HashMap<Integer, Integer> sar = new HashMap<>();

        arr = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr.get(from).add(new node(to, cost));
            arr.get(to).add(new node(from, cost));

        }
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(n>1){
        st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            int macpos = Integer.parseInt(st.nextToken());
            visit = new int[V + 1];
            Arrays.fill(visit, INF);
            Dij(macpos);
            for (int j = 0; j < visit.length; j++) {
                if (visit[j] <= M) {
                    mac.put(j, Math.min(visit[j], mac.getOrDefault(j, Integer.MAX_VALUE)));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        if (n1 > 1) {
            st = new StringTokenizer(br.readLine());

        }
        for (int i = 0; i < n1; i++) {
            int starpos = Integer.parseInt(br.readLine());
            if(mac.get(starpos)==null)continue;
            visit = new int[V + 1];
            Arrays.fill(visit, INF);
            Dij(starpos);
            for (int j = 0; j < visit.length; j++) {
                if (visit[j] <= S) {
                    sar.put(j, Math.min(visit[j], mac.get(j)));
                }
            }
        }
        int value = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i < V + 1; i++) {
            if (mac.get(i) == null || sar.get(i) == null) continue;
            if (value > mac.get(i) + sar.get(i)) {
                value = mac.get(i) + sar.get(i);
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static void Dij(int start) {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.add(new node(start, 0));
        visit[start] = 0;

        while (!que.isEmpty()) {
            node z = que.poll();

            if (visit[z.to] < z.value) continue;

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                node next = arr.get(z.to).get(i);

                if (visit[next.to] > next.value + z.value) {
                    visit[next.to] = next.value + z.value;
                    que.add(new node(next.to, next.value + z.value));
                }
            }
        }
    }
}
