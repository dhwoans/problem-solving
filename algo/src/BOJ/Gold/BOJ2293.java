package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {//풀이중

    private static int k;
    private static int n;
    private static int[] coin;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;
        coin = new int[n];
        int[][] dp = new int[k][n];

        //정보입력
        for (int i = 0; i < coin.length; i++) {
            coin[i]=Integer.parseInt(br.readLine());
        }



        
        
        
    }
}
