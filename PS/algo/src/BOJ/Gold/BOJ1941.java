package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ_1941_소문난 칠공주
 * @date : 2021. 12. 01.
 * @language : JAVA
 * @classification : brute force
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 25개중에 7개 뽑는다
 **/
public class BOJ1941 {//풀이중

    static char[][] map;
    static boolean[][] visit;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];

        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        Dfs(0);
    }

    private static void Dfs(int n) {
       if(n==7){
         cal();
       }
        for (int i = 0; i < 4; i++) {

        }
    }
    private static void cal() {

    }
}
