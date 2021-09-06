package exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert7829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int answer =0;
            if(size==1){
                answer =arr[0]*arr[0];
            }else if(size%2==0){
                size/=2;
                answer=arr[size]*arr[size-1];
            }else{
                size/=2;
                answer=arr[size]*arr[size];
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
