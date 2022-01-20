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
public class BOJ13911 {// 풀이중
    static ArrayList<ArrayList<node>> arr;
    static int V,E;
    static int[] visit;
    static boolean[] store;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        ArrayList<Integer> macpos = new ArrayList<>();
        ArrayList<Integer> starpos = new ArrayList<>();
        HashMap<Integer, Integer> mac = new HashMap<>();
        HashMap<Integer, Integer> star = new HashMap<>();

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
        //햄버거 위치 위치 파악
        st = new StringTokenizer(br.readLine());
        int macCount = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        if(macCount==1){
            int n1 =Integer.parseInt(br.readLine());
            store[n1]=true;
            macpos.add(n1);
        }else{
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < macCount; i++) {
                int n2 = Integer.parseInt(st.nextToken());
                store[n2]=true;
                macpos.add(n2);
            }
        }
        st = new StringTokenizer(br.readLine());
        int starCount = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if(starCount==1){
            int n1 =Integer.parseInt(br.readLine());
            store[n1]=true;
            starpos.add(n1);
        }else{
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < macCount; i++) {
                int n2 = Integer.parseInt(st.nextToken());
                store[n2]=true;
                starpos.add(n2);
            }
        }
        //맥세권 찾기
        for (int i = 0; i < macpos.size(); i++) {
            Dij(mac.get(i));

        }
    }

    private static void Dij(int start) {
        visit = new int[V+1];
        Arrays.fill(visit,INF);

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
