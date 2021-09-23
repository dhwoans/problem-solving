package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int v,e;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new boolean[v+1];
        int count= 0;
        //인접 리스트 생성
        arr = new ArrayList<>();
        //v수만큼 리스트 넣기
        for (int i = 0; i < v+1; i++) {
            arr.add(new ArrayList<>());
        }
        //값넣기
        for (int i = 0; i < e; i++) {
            st= new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }
        for (int i = 1; i < v+1; i++) {
            if(!visit[i]){
                count++;
                visit[i]=true;
                dfs(i);
            }
        }
        System.out.println(count);

    }
    static void dfs(int start){
        for (int i = 0; i < arr.get(start).size(); i++) {
            if(!visit[arr.get(start).get(i)]){
                visit[arr.get(start).get(i)]=true;
                dfs(arr.get(start).get(i));
            }
        }
    }
}
