package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ12847
 * @date : 2021-12-28
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = 0;
        long sum = 0;
        long answer =0;
        int[] arr = new int[N];

        //값 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for (int end = 0; end < arr.length; end++) {
            sum+=arr[end];

            if(end>=M-1){
                answer = Math.max(answer, sum);
                sum-=arr[start];
                start++;
            }
        }
        System.out.println(answer);
    }
}
