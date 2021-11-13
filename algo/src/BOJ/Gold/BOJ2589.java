package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2589.보물선
 * 
 * dfs
 */
public class BOJ2589 {
    static char[][] map;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        map =new char[n][m];
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        dfs();
    }

    private static void dfs() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

            }

        }
    }
}
