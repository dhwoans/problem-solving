package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            //비교
            int max = 0;
            int[] map = new int[n];

            int head =0;
            int tail =n-1;
            for (int j = 0; j < arr.length; j++) {
                if(j%2==0){
                    map[head++]=arr[j];
                }else{
                    map[tail--]=arr[j];
                }
            }
            for (int j = 0; j < n-1; j++) {
                max = Math.max(max,Math.abs(map[j]-map[j+1]));
            }
            System.out.println(max);
        }


    }
}
