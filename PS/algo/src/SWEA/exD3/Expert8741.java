package SWEA.exD3;

import java.io.*;
import java.util.StringTokenizer;

public class Expert8741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data = "3\n" +
                "knuth morris pratt\n" +
                "recurrent neural network\n" +
                "advanced encryption standard";
        br= new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.printf("#%d ",test_case);
            for (int i = 0; i < 3; i++) {
                System.out.print((char)(st.nextToken().charAt(0)-32));
            }
            System.out.println();
        }


    }
}
