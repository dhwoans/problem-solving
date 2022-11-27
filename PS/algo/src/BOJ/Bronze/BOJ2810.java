package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        str = str.replace("LL", "S");
        int answer = str.length() + 1;

        if (N < answer) {
            System.out.println(N);
        } else {
            System.out.println(answer);

        }

    }
}
