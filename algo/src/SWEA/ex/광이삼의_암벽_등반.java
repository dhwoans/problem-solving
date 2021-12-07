package SWEA.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 광이삼의_암벽_등반 {
    static class xy{
        int x;
        int y;

        xy(int x,int y){
            this.x =x;
            this.y =y;
        }
    }
    static int N,M,L,result;
    static ArrayList<xy> arr;
    static boolean[] visit;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            //map 생성
            int[][] map = new int[N][M];
            //고리가 있는 위치
            arr = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st= new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[j][k]= Integer.parseInt(st.nextToken());
                    if(map[j][k]==1){
                        arr.add(new xy(j,k));
                    }
                }
            }
            visit= new boolean[arr.size()];

            flag = false;
            result =Integer.MAX_VALUE;
            Dfs(N-1,0,0);
            if(flag){
                System.out.println("#"+i+" "+result);
            }else{
                System.out.println("#"+i+" "+(-1));
            }


        }
    }

    private static void Dfs(int r,int c,int count) {

        if (Math.abs(r - 0) + Math.abs(c - (M - 1)) <= L) {
            flag = true;
            result = Math.min(result,count);
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            int cal = Math.abs(arr.get(i).x - r) + Math.abs(arr.get(i).y - c);
            if (cal <= L && !visit[i]) {
                visit[i] = true;
                Dfs(arr.get(i).x, arr.get(i).y, count + 1);
                visit[i] = false;
            }
        }

    }

}
