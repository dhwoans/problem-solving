package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Expert10200 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data = "3\n" +
                "10 3 5\n" +
                "10 7 5\n" +
                "100 100 100\n";
        br = new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer1 = a>b?b:a;
            int answer2 = n-(a+b)<0?(a+b)-n:0;

            System.out.println("#"+test_case+" "+answer1+" "+answer2);
        }

    }
}
