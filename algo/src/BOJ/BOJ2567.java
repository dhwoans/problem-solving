package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[100][100];

        int T =Integer.parseInt(br.readLine());
        int[] rr = new int[T];
        int[] cc = new int[T];


        for (int i = 0; i <T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rr[i]=r;
            cc[i]=c;
            for (int j = r; j < 10+r; j++) {
                for (int k = c; k < 10+c; k++) {
                    if(map[j][k]==1)continue;
                    map[j][k]=1;
                }

            }
        }
        for (int i = 0; i < T; i++) {
            for (int j = rr[i]+1; j < 9+rr[i]; j++) {
                for (int k = cc[i]+1; k < 9+cc[i]; k++) {
                    map[j][k]=0;
                }
            }

        }
        int count =0;
        for (int[] ints : map) {
            for (int anInt : ints) {

                if (anInt == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
