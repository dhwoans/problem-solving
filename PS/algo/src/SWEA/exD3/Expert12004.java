package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert12004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String answer = "No";
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j <10 ; j++) {
                    if(n==i*j){
                        answer = "Yes";
                    }
                }

            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
