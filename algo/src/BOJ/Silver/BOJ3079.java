package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_3079_입국심사
 * @date : 2021. 12. 11.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());                // 입국심사대
        int M = Integer.parseInt(br.readLine());                // 대기인원
        int min = 0;
        int max = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        max =arr[arr.length-1]*M;

        while(min<max){
            int
        }

    }
}
