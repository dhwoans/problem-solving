package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_2003_수들의 합 2
 * @date : 2021. 12. 01.
 * @language : JAVA
 * @classification : sliding window
 * @time_limit : 0.5sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 슬라이딩 윈도우를 익혀보자
 **/
public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        //값입력
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int l =0;
        int r =0;
        int sum = 0;
        int answer = 0;

        while(true){

            if(sum>= m){
                sum -= arr[l++];
            }else if(r==n) break;
            else if(sum<m){
                sum += arr[r++];
            }

            if(sum == m){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
