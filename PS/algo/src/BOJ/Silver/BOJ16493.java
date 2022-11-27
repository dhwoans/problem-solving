package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ16493
 * @date : 2021-12-22
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ16493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] days = new int[M+1];
        int[] pages = new int[M + 1];
        int[][] map = new int[M + 1][N + 1];

        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            days[i]= Integer.parseInt(st.nextToken());
            pages[i]= Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                if(days[i]<=j){
                    map[i][j]=Math.max(map[i-1][j],pages[i]+map[i-1][j-days[i]]);
                }else{
                    map[i][j]=map[i-1][j];
                }
            }
        }

        System.out.println(map[M][N]);
    }
}
