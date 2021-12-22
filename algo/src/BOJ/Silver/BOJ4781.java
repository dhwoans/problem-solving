package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ4781
 * @date : 2021-12-22
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());

            if(c==0&&m==0.00)break;

            int[][] map = new int[c+1][(int)m*100+1];
            int[] cost = new int[c + 1];
            int[] cal = new int[c + 1];

            for (int i = 1; i < c+1; i++) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                double calorie = Double.parseDouble(st.nextToken());
                cost[i]= price;
                cal[i]= (int) calorie*100+1;
            }

            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map[0].length; j++) {
                    if (cost[i] <= j) {
                        map[i][j] = Math.max(map[i - 1][j], cal[i] + map[i][j - cost[i]]);
                    } else {
                        map[i][j] = map[i - 1][j];
                    }
                }
            }
            System.out.println(map[c][(int) m*100]);

        }
        
    }
}
