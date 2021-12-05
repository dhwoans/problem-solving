package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Bronze
 * @fileName : BOJ_1546_평균
 * @date : 2021. 12. 05.
 * @language : JAVA
 * @classification : math
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:00
 * @submissions : 1
 * @description
 *
 **/
public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max= 0;
        //입력값 받기
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        //재구성
        double sum = 0;
        for (int i : arr) {

            sum +=(double)i/max*100;
        }
        double answer = (sum)/n;
        System.out.println(answer);
    }
}
