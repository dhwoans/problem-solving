package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];


        //정보 입력
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(j==0){
                    map[i][j]+=Math.min(map[i-1][1],map[i-1][2]);
                }else if(j==1){
                    map[i][j]+=Math.min(map[i-1][0],map[i-1][2]);
                }else{
                    map[i][j]+=Math.min(map[i-1][0],map[i-1][1]);
                }
            }
        }
        int answer =Integer.MAX_VALUE;
        for (int i = 0; i < map[0].length; i++) {
            answer = Math.min(answer, map[N-1][i]);
        }
        System.out.println(answer);
    }


}
