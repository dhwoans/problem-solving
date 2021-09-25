package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {//풀이중
    static int T;
    static int[] sign;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[T-1];
        int[] num = new int[T];
        for (int i = 0; i < num.length; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        sign = new int[T-1];
        for (int i = 0; i < sign.length; i++) {
            sign[i]=Integer.parseInt(st.nextToken());
        }

    }
    static void DFS(int cnt){
        if(cnt == T-1){

        }
        for (int i = 0; i < T-1; i++) {
            if(visit[i])continue;
            visit[i]=true;
            DFS(cnt+1);
            visit[i]=false;
        }
    }
}
