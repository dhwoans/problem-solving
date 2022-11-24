package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ1719
 * @date : 2022-01-19
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1719 {
    static int n,m;
    static ArrayList<ArrayList<Node>> arr;
    static int[] visit;
    static int[] path;
    static final int INF =987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());




        arr= new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new Node(to,cost));
            arr.get(to).add(new Node(from,cost));
            
        }
        for (int i = 1; i < n+1; i++) {
            visit= new int[n+1];
            path = new int[n+1];
            Arrays.fill(visit,INF);
            Dij(i);
        }
        

    }

    private static void Dij(int i) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(i,0));
        visit[i]=0;

        while (!que.isEmpty()){
            Node z = que.poll();

            if(visit[z.to]<z.value)continue;

            for (int j = 0; j < arr.get(z.to).size(); j++) {
                Node next = arr.get(z.to).get(j);
                if(visit[next.to]>z.value+next.value){
                    path[next.to]=z.to;
                    visit[next.to]=z.value+next.value;
                    que.add(new Node(next.to,z.value+next.value));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < n+1; j++) {
            if(j==i){
                sb.append("-").append(" ");
            }else{
                sb.append(find(j, i)).append(" ");
            }
            
        }
        System.out.println(sb.toString());
    }

    private static int find(int j, int i) {
        if(path[j]==i) return j;
        return find(path[j], i);
    }
}
