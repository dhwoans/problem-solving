package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            int[] ints = new int[N];
            st= new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ints[i]=Integer.parseInt(st.nextToken());
            }
            int count= 0;
            for (int i : ints) {
                if(i==0){
                    count++;
                }
            }
            System.out.println("#"+test_case+" "+count/dis);
        }
    }
}
