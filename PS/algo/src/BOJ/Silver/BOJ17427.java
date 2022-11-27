package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long sum =1;

        for(int i =2;i<n+1;i++) {
            sum += 1;
            for (int j = 1; j < n+1; j++) {
                if (i * j > n) break;
                sum += i;
            }
        }

        System.out.println(sum);

    }
}
