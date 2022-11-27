package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            st=new StringTokenizer(br.readLine());
            int w =Integer.parseInt(st.nextToken());
            int v =Integer.parseInt(st.nextToken());

            weight[i]=w;
            value[i]=v;
        }
        int[][] map = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                //물건 넣을 수 있는 경우
                if(weight[i]<=j){
                    map[i][j]=Math.max(map[i-1][j],value[i]+map[i-1][j-weight[i]]);
                }else{
                    map[i][j]=map[i-1][j];
                }
            }
        }
        System.out.println(map[n][k]);
        for (int[] ints : map) {
            for (int a : ints) {
                System.out.print(a+"\t");
            }
        System.out.println();
        }
    }
}
