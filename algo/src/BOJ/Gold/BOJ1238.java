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
public class BOJ1238 {
    static int N,M,X;
    static ArrayList<ArrayList<Node>> arr;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        //arr 생성
        arr = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            arr.add(new ArrayList<>());
        }
        
        //간선정보
        //단방향
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new Node(to,cost));
            
        }
        //X로 오는 길
        visit = new int[N+1];
        Dij(X);
        int[] answer = Arrays.copyOf(visit,visit.length);

        //X에서 가는 길
        for (int i = 1; i < N+1 ; i++) {
            Dij(i);
            answer[i]+=visit[X];
        }

        int value = Arrays.stream(answer).filter(i->i!=Integer.MAX_VALUE).max().orElse(-1);

        System.out.println(value);
    }

    private static void Dij(int X) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X,0));
        Arrays.fill(visit,Integer.MAX_VALUE);
        visit[X]=0;

        while(!pq.isEmpty()){
            Node z = pq.poll();

            if(visit[z.to]<z.value)continue;


                for (int j = 0; j < arr.get(z.to).size(); j++) {
                    Node next = arr.get(z.to).get(j);
                    if(visit[next.to]>visit[z.to]+next.value){
                        visit[next.to]=visit[z.to]+next.value;
                        pq.add(new Node(next.to,visit[next.to]));
                    }
                }

        }
    }
}
