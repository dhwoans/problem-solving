package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int sum = 0;
        String num = br.readLine();
        for (int i = 0; i < len; i++) {
            sum += num.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
