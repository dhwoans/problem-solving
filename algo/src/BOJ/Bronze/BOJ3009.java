package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
         BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int[] X = new int[1002];
        int[] Y = new int[1002];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                X[x]++;
                Y[y]++;

        }
        for (int i = 1; i < X.length; i++) {

            if(X[i]==1){
                System.out.print(i+" ");
            }
        }
        for (int i = 1; i < X.length; i++) {

            if(Y[i]==1){
                System.out.println(i);
            }
        }

    }
}
