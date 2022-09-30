package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {

    private static int k;
    private static int[] dis;
    private static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        //연결정보
        arr = new ArrayList<>();
        dis = new int[n];
        Arrays.fill(dis,987654321);
        dis[x]=0;
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken())-1;
            int to  = Integer.parseInt(st.nextToken())-1;
            arr.get(from).add(to);

        }
        dfs(x);
        boolean flag =true;
        for (int i = 0; i < dis.length; i++) {
            if(dis[i]==k){
                System.out.println(i+1);
                flag = false;
            }
        }
        if(flag) System.out.println(-1);
    }

    private static void dfs(int start) {
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{start,1});
        while(!que.isEmpty()){
            Integer[] temp = que.poll();

            for (int i = 0; i < arr.get(temp[0]).size(); i++) {
                int next = arr.get(temp[0]).get(i);
                if(dis[next]>temp[1]){
                    dis[next]=temp[1];
                    que.add(new Integer[]{next,temp[1]+1});
                }
            }
        }
    }
}
