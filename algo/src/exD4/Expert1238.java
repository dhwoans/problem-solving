package exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Expert1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());
            ArrayList<Integer> graph = new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < len/2; i++) {
                int from = Integer.parseInt(br.readLine());
                int to = Integer.parseInt(br.readLine());



            }


        }
    }
}
