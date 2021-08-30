package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = 1;
        int sum = 0;
        for (int i = 2; i <= T; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sum++;
                }

            }
            if(sum%2==1){
                sum++;
            }
            answer+=sum/2;
            sum=0;
        }
        System.out.println(answer);

    }
}