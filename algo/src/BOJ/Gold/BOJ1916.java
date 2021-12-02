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
 * @fileName : BOJ_1916_최소비용 구하기
 * @date : 2021. 11. 29.
 * @language : JAVA
 * @classification : sort
 * @time_limit : 0.5sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 다익스트라 풀기
 **/
public class BOJ1916 {
    static ArrayList<ArrayList<node>>arr;
    static int[] visit;
    static int INF =987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int v  = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        StringTokenizer st;

        //리스트 생성
        arr = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            arr.add(new ArrayList<>());
        }

        //입력받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            arr.get(from).add(new node(to,cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        visit = new int[v+1];
        Dji(start);
        System.out.println(visit[end]);
    }

    private static void Dji(int start) {
        Arrays.fill(visit,INF);
        PriorityQueue<node> que = new PriorityQueue<>();
       que.add(new node(start,0));
       visit[start]=0;
       while (!que.isEmpty()){
           node z = que.poll();

           if(visit[z.to]<z.value)continue;

           for (int i = 0; i < arr.get(z.to).size(); i++) {
               node next = arr.get(z.to).get(i);
               if(visit[next.to]>visit[z.to]+next.value){
                   visit[next.to]=visit[z.to]+next.value;
                   que.add(new node(next.to,visit[next.to]));
               }
           }
       }
    }
}
