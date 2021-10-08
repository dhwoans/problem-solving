package SWEA.exD5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 4014.활주로 건설
 */
public class Expert4014 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\ttest\\algorithm\\algo\\src\\input\\input4014.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];

            //값 입력 받기
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로 탐색
            int count=0;
            for (int i = 0; i < map.length; i++) {
                int heigth[] = new int[7];
                int max =0;
                boolean flag =true;
                for (int j = 0; j < map.length; j++) {
                    heigth[map[i][j]]++;
                    max= Math.max(max,map[i][j]);
                }
                for (int j = 1; j < max; j++) {
                    if(heigth[j]!=0&&heigth[j]<x){
                        flag=false;
                        break;
                    }
                }
                if(flag)count++;
            }
            for (int j = 0; j < map.length; j++) {
                int heigth[] = new int[7];
                int max =0;
                boolean flag =true;
                for (int i = 0; i < map.length; i++) {
                    heigth[map[i][j]]++;
                    max= Math.max(max,map[i][j]);
                }
                for (int z = 0; z < max; z++) {
                    if(heigth[z]!=0&&heigth[z]<x){
                        flag=false;
                        break;
                    }
                }
                if(flag)count++;
            }
        System.out.println("#"+test_case+" "+count);
        }
    }
}
