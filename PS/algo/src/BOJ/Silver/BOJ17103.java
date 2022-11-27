package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //체만들기
        boolean[] primeNum = new boolean[1_000_000];
        Arrays.fill(primeNum,true);

        for (int i = 2; i <= 500_000; i++) {
            for (int j = 2; j <= 500_000; j++) {
                if(i*j>=1_000_000)break;
                else primeNum[i*j]=false;
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= n/2; j++) {
                if(primeNum[j]&&primeNum[n-j])count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
