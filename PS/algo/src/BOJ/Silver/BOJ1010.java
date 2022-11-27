package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {

    private static boolean[] arr;
    private static int w;
    private static int e;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            int big = Math.max(w,e-w);
            int small = big==w?e-w:w;
            long sum =1;
            long sum2 =1;
            for (int j = e; j > big; j--) {
                sum*=j;
            }
            for (int j = 1; j <= small; j++) {
                sum2*=j;
            }

            System.out.println(sum/sum2);
        }

        
    }
}
