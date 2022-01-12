package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ1707
 * @date : 2022-01-11
 * @language : JAVA
 * @classification : graph
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ1707 {
    static int visit[];
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        visit = new int[V+1];
        arr = new ArrayList<>();

        for (int i = 0; i < V+1; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(from).add(to);
        }
        Bfs(); //이분 그래프 만들기
    }


    private static void Bfs() {
        boolean flag =true;
        Queue<Integer> que = new LinkedList();
        que.add(1);
        visit[1]=2;

        while(!que.isEmpty()){
            int z = que.poll();

            for (int i = 0; i < arr.get(z).size(); i++) {
                int next = arr.get(z).get(i);
                if(visit[next]!=0){
                    if(flag){
                        visit[next]=2;
                    }else{

                    }
                }else{
                    if(flag){
                        visit[next]=1;
                    }else{
                        visit[next]=2;
                    }
                }

                
            }
            if(flag){
                flag=false;
            }else{
                flag=true;
            }
        }
    }
}
