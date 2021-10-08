package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.print("#" + test_case + " ");
            String str = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == 'p') {
                    sb.append('q');
                } else if (str.charAt(i) == 'q') {
                    sb.append('p');

                } else if (str.charAt(i) == 'b') {
                    sb.append('d');
                } else if (str.charAt(i) == 'd') {
                    sb.append('b');
                }

            }
            System.out.println(sb);

        }
    }
}
