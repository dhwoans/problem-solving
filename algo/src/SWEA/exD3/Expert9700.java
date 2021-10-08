package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert9700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String data ="2\n" +
//                "0.8 0.5\n" +
//                "0.6 0.5";
//        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double p=Double.parseDouble(st.nextToken());
            double q=Double.parseDouble(st.nextToken());
            double s1 =(1-p)*q;
            double s2 =p*(1-q)*q;

            if (s1 < s2) {
                System.out.println("#" + test_case + " " + "YES");
            } else
                System.out.println("#" + test_case + " " + "NO");

        }

    }
}
