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
 * @fileName : BOJ5972
 * @date : 2022-01-19
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ5972 {
    static ArrayList<ArrayList<Node>> arr;
    static int[] visit;
    static final int INF =987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new int[n+1];
        Arrays.fill(visit,INF);

        arr = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new Node(to,cost));
            arr.get(to).add(new Node(from,cost));
        }

        Dji();
        System.out.println(visit[n]);
    }

    private static void Dji() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.add(new Node(1,0));
        visit[1]=0;

        while (!que.isEmpty()){
            Node z = que.poll();

            if(visit[z.to]<z.value)continue;

            for (int i = 0; i < arr.get(z.to).size(); i++) {
                Node next= arr.get(z.to).get(i);
                if(visit[next.to]>next.value+z.value){
                    visit[next.to]=next.value+z.value;
                    que.add(new Node(next.to,next.value+z.value));
                }
            }
        }
    }
}
