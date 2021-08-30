package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Expert7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String data ="1\n" +
//                    "10 2\n" +
//                    "0 0 1 0 1 0 0 0 0 1";
//
//        br = new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            int[] ints = new int[N+1];
            ints[0]=1;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < ints.length; i++) {
                ints[i] = Integer.parseInt(st.nextToken());
            }
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < ints.length; i++) {
               if(ints[i]==1){
                   for (int j = i+1; j <=dis+i ; j++) {
                       if(j>=ints.length) break;
                       if(ints[j]==1){
                           flag=false;
                           break;
                       }else{
                           flag =true;
                       }

                   }
                   if(flag){
                       count++;
                       ints[i+dis]=1;
                       flag = false;
                   }

               }
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}
