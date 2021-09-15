package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] D = new int[num+1];
        int min = Integer.MAX_VALUE;
        D[1]=0;
        for (int i = 2; i <= num; i++) {
            D[i]=D[i-1]+1;
            if(i%3==0){
                D[i]= Math.min(D[i/3]+1,D[i]);
            }
            if(i%2==0){
                D[i]=Math.min(D[i/2]+1,D[i]);
            }

        }
        System.out.println(D[num]);

    }
}
