package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean flag = true;
            boolean[] alphabet = new boolean[27];

            for (int j = 0; j < str.length(); j++) {


                if (j != str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) continue;

                if (!alphabet[str.charAt(j) - 'a']) {
                    alphabet[str.charAt(j) - 'a'] = true;
                } else {
                    flag = false;
                    break;
                }


            }
            if (flag) count++;
        }
        System.out.println(count);
    }
}
