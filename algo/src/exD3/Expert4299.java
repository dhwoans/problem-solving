package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int day =0;
            int hour=0;
            int min =0;
            if(D!=11){
                day=(D-11)*24*60;
            }
            if(H!=11){
                hour=(H-11)*60;
            }
            if(M!=11){
                min=(M-11);
            }
            int answer = day+hour+min;
            if(answer<0) answer =-1;
            System.out.println("#"+test_case+" "+answer);

        }
    }
}
